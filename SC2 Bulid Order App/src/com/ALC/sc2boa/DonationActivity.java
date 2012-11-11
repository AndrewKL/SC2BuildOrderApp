package com.ALC.sc2boa;

import java.math.BigDecimal;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.paypal.android.MEP.CheckoutButton;
import com.paypal.android.MEP.PayPal;
import com.paypal.android.MEP.PayPalPayment;
import com.paypal.android.MEP.PayPalInvoiceData;
import com.paypal.android.MEP.PayPalInvoiceItem;


public class DonationActivity extends Activity implements OnClickListener {
	
			private static final int server = PayPal.ENV_SANDBOX;//sandbox for now // The PayPal server to be used - can also be ENV_NONE and ENV_LIVE
			private static final String appID = "APP-80W284485P519543T"; // The ID of your application that you received from PayPal//APP-80W284485P519543T == paypal sandbox id
			private static final int request = 1;// This is passed in for the startActivityForResult() android function, the value used is up to you

			public static final String build = "12.11.10.0";

			protected static final int INITIALIZE_SUCCESS = 0;
			protected static final int INITIALIZE_FAILURE = 1;

			TextView labelSimplePayment;
			LinearLayout layoutSimplePayment;
			CheckoutButton launchSimplePayment;
			Button exitApp;
			TextView title;
			TextView info;
			TextView extra;
			TextView labelKey;
			TextView appVersion;
			EditText enterPreapprovalKey;

			public static String resultTitle;//success/failure/cancelled
			public static String resultInfo;//
			public static String resultExtra;
			//private String isuename;
			private String donationDollarAmount;

			Handler hRefresh = new Handler(){
			    @Override
			    public void handleMessage(Message msg) {
			        switch(msg.what){

			        case INITIALIZE_SUCCESS:
			            setupButtons();
			            break;
			        case INITIALIZE_FAILURE:
			            showFailure();
			            break;
			        }
			    }
			};

			@Override
			public void onCreate(Bundle savedInstanceState) {
			    super.onCreate(savedInstanceState);
			    requestWindowFeature(Window.FEATURE_NO_TITLE);
			    Thread libraryInitializationThread = new Thread() {
			        @Override
			        public void run() {
			            initLibrary();
			            // The library is initialized so let's create our CheckoutButton and update the UI.
			            if (PayPal.getInstance().isLibraryInitialized()) {
			                hRefresh.sendEmptyMessage(INITIALIZE_SUCCESS);
			            }
			            else {
			                hRefresh.sendEmptyMessage(INITIALIZE_FAILURE);
			            }
			        }
			    };
			    libraryInitializationThread.start();

			     //isuename=getIntent().getStringExtra("name").trim();
			     donationDollarAmount="4.00";//TODO

			     //Log.v("isuename ",""+isuename);
			     //Log.v("isueprice ",""+donationDollarAmount);

			    LinearLayout content = new LinearLayout(this);
			    content.setLayoutParams(new LayoutParams(android.view.ViewGroup.LayoutParams.FILL_PARENT, android.view.ViewGroup.LayoutParams.FILL_PARENT));
			    content.setGravity(Gravity.CENTER_HORIZONTAL);
			    content.setOrientation(LinearLayout.VERTICAL);
			    content.setPadding(0, 0, 0, 0);
			    content.setBackgroundColor(Color.WHITE);

			    layoutSimplePayment = new LinearLayout(this);
			    layoutSimplePayment.setLayoutParams(new LayoutParams(android.view.ViewGroup.LayoutParams.FILL_PARENT, android.view.ViewGroup.LayoutParams.FILL_PARENT));
			    layoutSimplePayment.setGravity(Gravity.CENTER_HORIZONTAL);
			    layoutSimplePayment.setOrientation(LinearLayout.VERTICAL);
			    layoutSimplePayment.setPadding(0, 5, 0, 5);

			    labelSimplePayment = new TextView(this);
			    labelSimplePayment.setGravity(Gravity.CENTER_HORIZONTAL);
			    labelSimplePayment.setText("ACL");
			    labelSimplePayment.setTextColor(Color.RED);
			    labelSimplePayment.setTextSize(45.0f);

			    layoutSimplePayment.addView(labelSimplePayment);
			          //        labelSimplePayment.setVisibility(View.GONE);

			    content.addView(layoutSimplePayment);

			    LinearLayout layoutKey = new LinearLayout(this);
			    layoutKey.setLayoutParams(new LayoutParams(android.view.ViewGroup.LayoutParams.WRAP_CONTENT, android.view.ViewGroup.LayoutParams.WRAP_CONTENT));
			    layoutKey.setGravity(Gravity.CENTER_HORIZONTAL);
			    layoutKey.setOrientation(LinearLayout.VERTICAL);
			    layoutKey.setPadding(0, 0, 0, 0);

			    
			    title = new TextView(this);
			    title.setLayoutParams(new LinearLayout.LayoutParams(android.view.ViewGroup.LayoutParams.FILL_PARENT, android.view.ViewGroup.LayoutParams.WRAP_CONTENT));
			    title.setPadding(0, 5, 0, 5);
			    title.setGravity(Gravity.CENTER_HORIZONTAL);
			    title.setTextSize(30.0f);
			    title.setVisibility(View.GONE);
			    content.addView(title);

			    info = new TextView(this);
			    info.setLayoutParams(new LinearLayout.LayoutParams(android.view.ViewGroup.LayoutParams.FILL_PARENT, android.view.ViewGroup.LayoutParams.WRAP_CONTENT));
			    info.setPadding(0, 5, 0, 5);
			    info.setGravity(Gravity.CENTER_HORIZONTAL);
			    info.setTextSize(20.0f);
			    info.setVisibility(View.VISIBLE);
			    info.setText("Please Wait! Initializing Paypal...");
			    info.setTextColor(Color.BLACK);
			    content.addView(info);

			    extra = new TextView(this);
			    extra.setLayoutParams(new LinearLayout.LayoutParams(android.view.ViewGroup.LayoutParams.FILL_PARENT, android.view.ViewGroup.LayoutParams.WRAP_CONTENT));
			    extra.setPadding(0, 5, 0, 5);
			    extra.setGravity(Gravity.CENTER_HORIZONTAL);
			    extra.setTextSize(12.0f);
			    extra.setVisibility(View.GONE);
			    content.addView(extra);

			    LinearLayout layoutExit = new LinearLayout(this);
			    layoutExit.setLayoutParams(new LayoutParams(android.view.ViewGroup.LayoutParams.FILL_PARENT, android.view.ViewGroup.LayoutParams.FILL_PARENT));
			    layoutExit.setGravity(Gravity.CENTER_HORIZONTAL);
			    layoutExit.setOrientation(LinearLayout.VERTICAL);
			    layoutExit.setPadding(0, 15, 0, 5);

			    exitApp = new Button(this);
			    exitApp.setLayoutParams(new LayoutParams(200, android.view.ViewGroup.LayoutParams.WRAP_CONTENT)); //Semi mimic PP button sizes
			    exitApp.setOnClickListener(this);
			    exitApp.setText("Exit");
			    layoutExit.addView(exitApp);
			    content.addView(layoutExit);

			    appVersion = new TextView(this);
			    appVersion.setGravity(Gravity.CENTER_HORIZONTAL);
			    appVersion.setPadding(0, -5, 0, 0);
			    appVersion.setText("\n\nSimple Demo Build " + build + "\nMPL Library Build " + PayPal.getBuild());
			    content.addView(appVersion);
			    appVersion.setVisibility(View.GONE);

			    setContentView(content);
			}
			public void setupButtons() {
			    PayPal pp = PayPal.getInstance();
			    
			    launchSimplePayment = pp.getCheckoutButton(this, PayPal.BUTTON_194x37, CheckoutButton.TEXT_DONATE);// Get the CheckoutButton. There are five different sizes. The text on the button can either be of type TEXT_PAY or TEXT_DONATE.
			    launchSimplePayment.setOnClickListener(this);//add listener
			    layoutSimplePayment.addView(launchSimplePayment);// The CheckoutButton is an android LinearLayout so we can add it to our display like any other View.
			    labelSimplePayment.setVisibility(View.VISIBLE);// Show our labels and the preapproval EditText.


			    info.setText("");
			    info.setVisibility(View.GONE);
			}
			public void showFailure() {
			    title.setText("FAILURE");
			    info.setText("Could not initialize the PayPal library.");
			    title.setVisibility(View.VISIBLE);
			    info.setVisibility(View.VISIBLE);
			}
			private void initLibrary() {
			    PayPal pp = PayPal.getInstance();

			    if(pp == null) {

			        pp = PayPal.initWithAppID(this, appID, server);
			        pp.setLanguage("en_US"); // Sets the language for the library.
			        pp.setFeesPayer(PayPal.FEEPAYER_EACHRECEIVER); 
			        // Set to true if the transaction will require shipping.
			        pp.setShippingEnabled(false);
			        // Dynamic Amount Calculation allows you to set tax and shipping amounts based on the user's shipping address. Shipping must be
			        // enabled for Dynamic Amount Calculation. This also requires you to create a class that implements PaymentAdjuster and Serializable.
			        //pp.setDynamicAmountCalculationEnabled(false);
			    }
			}

			private PayPalPayment exampleSimplePayment() {
			    
			    PayPalPayment payment = new PayPalPayment(); // Create a basic PayPalPayment.
			    
			    payment.setCurrencyType("USD"); // Sets the currency type for this payment.
			    payment.setRecipient("ALC_1352600102_biz@gmail.com"); // Sets the recipient for the payment. This can also be a phone number.
			    payment.setSubtotal(new BigDecimal(donationDollarAmount));// Sets the amount of the payment, not including tax and shipping amounts.
			    payment.setPaymentType(PayPal.PAY_TYPE_SIMPLE);// Sets the payment type. This can be PAYMENT_TYPE_GOODS, PAYMENT_TYPE_SERVICE, PAYMENT_TYPE_PERSONAL, or PAYMENT_TYPE_NONE.

			    // PayPalInvoiceData can contain tax and shipping amounts. It also contains an ArrayList of PayPalInvoiceItem which can
			    // be filled out. These are not required for any transaction.
			    PayPalInvoiceData invoice = new PayPalInvoiceData();
			    invoice.setTax(new BigDecimal("0"));// Sets the tax amount.
			    invoice.setShipping(new BigDecimal("0")); // Sets the shipping amount.

			    
			    PayPalInvoiceItem item1 = new PayPalInvoiceItem();// PayPalInvoiceItem has several parameters available to it. None of these parameters is required.
			    item1.setName("Donation to SC2BOA development");// Sets the name of the item.
			    item1.setID("87239");// Sets the ID. This is any ID that you would like to have associated with the item.
			    // Sets the total price which should be (quantity * unit price). The total prices of all PayPalInvoiceItem should add up
			    // to less than or equal the subtotal of the payment.
			    /*  item1.setTotalPrice(new BigDecimal("2.99"));
			    // Sets the unit price.
			    item1.setUnitPrice(new BigDecimal("2.00"));
			    // Sets the quantity.
			    item1.setQuantity(3);*/
			    // Add the PayPalInvoiceItem to the PayPalInvoiceData. Alternatively, you can create an ArrayList<PayPalInvoiceItem>
			    // and pass it to the PayPalInvoiceData function setInvoiceItems().
			    invoice.getInvoiceItems().add(item1);

			    
			    payment.setInvoiceData(invoice); // Sets the PayPalPayment invoice data.
			    
			    payment.setMerchantName("ACL"); // Sets the merchant name. This is the name of your Application or Company.
			    //payment.setDescription();// Sets the description of the payment. depreciated
			    payment.setCustomID("SC2BOA Donation"); // Sets the Custom ID. This is any ID that you would like to have associated with the payment.
			    //payment.setIpnUrl("http://www.exampleapp.com/ipn"); // Sets the Instant Payment Notification url. This url will be hit by the PayPal server upon completion of the payment.
			    payment.setMemo("Donation to SC2:BOA development");// Sets the memo. This memo will be part of the notification sent by PayPal to the necessary parties.

			    return payment;
			}
			@Override
			public void onClick(View view) {
			    if(view == launchSimplePayment) {
			        PayPalPayment payment = exampleSimplePayment(); // Use our helper function to create the simple payment.
			        Intent checkoutIntent = PayPal.getInstance().checkout(payment, this, new ResultDelegate());// Use checkout to create our Intent.
			        startActivityForResult(checkoutIntent, request);// Use the android's startActivityForResult() and pass in our Intent. This will start the library.
			    } else if(view == exitApp) {
			        Intent intent = new Intent();
			        intent.putExtra("payment", "unpaid");
			        /*in.putExtra("condition", "false");*/
			        setResult(1,intent);//Here I am Setting the Requestcode 1, you can put according to your requirement
			        finish();
			    }
			}
			@Override
			public void onActivityResult(int requestCode, int resultCode, Intent data) {
			    if(requestCode != request)
			        return;

			    if(DonationActivity.resultTitle=="SUCCESS"){
			        Intent in = new Intent();
			        in.putExtra("payment", "paid");
			        setResult(22,in);

			    }else if(DonationActivity.resultTitle=="FAILURE"){
			        Intent in = new Intent();
			        in.putExtra("payment", "unpaid");
			        setResult(22,in);
			                 //         finish();
			    }else if(DonationActivity.resultTitle=="CANCELED"){
			        Intent in = new Intent();
			        in.putExtra("payment", "unpaid");
			        setResult(22,in);
			                  //            finish();
			    }


			    launchSimplePayment.updateButton();

			    //title.setText(resultTitle);
			    //title.setVisibility(View.VISIBLE);
			    info.setText(resultInfo);
			    info.setVisibility(View.VISIBLE);
			    extra.setText(resultExtra);
			    extra.setVisibility(View.VISIBLE);
			    finish();
			}
			@Override
			public boolean onKeyDown(int keyCode, KeyEvent event) {
			    if (keyCode == KeyEvent.KEYCODE_BACK) {
			        Intent in = new Intent();
			        in.putExtra("payment", "unpaid");
			        setResult(1,in);
			        finish();
			        return true;
			    }
			    return super.onKeyDown(keyCode, event);
			


		}
}
