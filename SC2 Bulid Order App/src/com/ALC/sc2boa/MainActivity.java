package com.ALC.sc2boa;

import java.math.BigDecimal;

import android.os.AsyncTask;
import android.os.Bundle;

import com.paypal.android.MEP.CheckoutButton;
import com.paypal.android.MEP.PayPal;
import com.paypal.android.MEP.PayPalActivity;
import com.paypal.android.MEP.PayPalPayment;
import com.paypal.android.MEP.PayPalInvoiceData;
import com.paypal.android.MEP.PayPalInvoiceItem;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
//import com.paypal.android.MECL.PayPal;


public class MainActivity extends Activity {
	class BuildOrderGenerator {

	}
	
	private static final int server = PayPal.ENV_SANDBOX;//sandbox for now // The PayPal server to be used - can also be ENV_NONE and ENV_LIVE
	private static final String appID = "APP-80W284485P519543T"; // The ID of your application that you received from PayPal//APP-80W284485P519543T == paypal sandbox id

	public final static String EXTRA_MESSAGE = "com.alc.sc2boa.MESSAGE";
	public final static String EXTRA_RACE = "com.alc.sc2boa.RACE";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        
        checkDatabase();
        
        return true;
    }
    
    
    private void checkDatabase() {
		BuildOrderDBManager dbmanager = new BuildOrderDBManager(this);
		//open dialog to dl more builds if there are none in the db
		if(dbmanager.getNumberOfBuilds()==0){
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
			 
			// set title
			alertDialogBuilder.setTitle("New BuildOrder Database Available");
 
			// set dialog message
			alertDialogBuilder.setMessage("Would you like to download builds from the web?");
			alertDialogBuilder.setCancelable(false);
			alertDialogBuilder.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						//load db if button pushed
						MainActivity.this.loadDataFromWeb(getCurrentFocus());
					}
				  });
			alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						dialog.cancel();
					}
				});
 
			// create and show alert dialog
			AlertDialog alertDialog = alertDialogBuilder.create();
			alertDialog.show();
		}
	}
		
		

    protected void loadDataFromWeb(View currentFocus) {
    	Log.d("ToolsActivity","loadDataFromWebButton: clicked");
		ProgressDialog mProgressDialog;

		// instantiate it within the onCreate method
		mProgressDialog = new ProgressDialog(MainActivity.this);
		mProgressDialog.setMessage("Downloading Builds");
		mProgressDialog.setIndeterminate(false);
		mProgressDialog.setMax(100);
		mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		//mProgressDialog.

		// execute this when the downloader must be fired
		DownloadXMLBuildFile downloadFile = new DownloadXMLBuildFile(mProgressDialog,MainActivity.this);
		downloadFile.execute(BuildOrderDBManager.ACLwebsiteurl);
		
	}
		
		
		
	

	/** Called when the user clicks the add build button */
    public void addBuild(View view) {
    	Intent intent = new Intent(this, AddBuildOrderActivity.class);
        startActivity(intent);
    }
    
    public void displayTools(View view) {
    	Intent intent = new Intent(this, ToolsActivity.class);
        startActivity(intent);
    }
    
    /** Called when the user clicks the list all builds button */
    public void listAllBuilds(View view) {
    	Intent intent = new Intent(this, SelectBuildOrderActivity.class);
        intent.putExtra(EXTRA_RACE, "all");
        startActivity(intent);
    }
    
    /** Called when the user clicks the list zerg builds button */
    public void listZergBuilds(View view) {
    	Intent intent = new Intent(this, SelectBuildOrderActivity.class);
        intent.putExtra(EXTRA_RACE, "zerg");
        startActivity(intent);
    }
    
    /** Called when the user clicks the list terran builds button */
    public void listTerranBuilds(View view) {
    	Intent intent = new Intent(this, SelectBuildOrderActivity.class);
        intent.putExtra(EXTRA_RACE, "terran");
        startActivity(intent);
    }
    /** Called when the user clicks the list protoss builds button */
    public void listProtossBuilds(View view) {
    	Intent intent = new Intent(this, SelectBuildOrderActivity.class);
        intent.putExtra(EXTRA_RACE, "protoss");
        startActivity(intent);
    }
    
    /** Called when the user clicks the donate button */
    public void donateButtonClick(View view) {
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.HowMuchWouldYouLikeToDonateString);
        builder.setItems(R.array.donation_ammounts_array, new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int which) {
                	   Log.d("mainactivity: ","onclick");
                   if(which==3){
                	   //TODO add select ammount ticker
                   }else{
                	   
                	   Resources res = getResources();
                	   Donate((((String[])res.getStringArray(R.array.donation_ammounts_array))[which]).replace("$", ""));     
                   }
               }
        });
        
        AlertDialog donateDialog = builder.create();
        donateDialog.show();
        
    	/*Intent intent = new Intent(this, DonationActivity.class);
        startActivity(intent);*/
    }
    private void Donate(String ammount){
    	Log.d("mainactivity: ","donate(string)");
    	ProgressDialog mDialog = new ProgressDialog(this);
        mDialog.setMessage("Please wait...");
        mDialog.setCancelable(false);
        mDialog.show();
        new Donate(ammount, mDialog).execute();
        
    }
    private class Donate extends AsyncTask<Void,Void,Void>{
    	String dollaramount;
    	ProgressDialog progressdialog;
    	
    	public Donate(String dollars, final ProgressDialog progress){
    		dollaramount=dollars;
    		progressdialog=progress;
    		
    	}

		@Override
		protected Void doInBackground(Void... params) {
			PayPal pp = PayPal.getInstance();

		    if(pp == null) {
		    	Log.d("mainactivity: ","doinbackground init paypal");
		        pp = PayPal.initWithAppID(MainActivity.this, appID, server);
		        pp.setLanguage("en_US"); // Sets the language for the library.
		        pp.setFeesPayer(PayPal.FEEPAYER_EACHRECEIVER); 
		        pp.setShippingEnabled(false);// Set to true if the transaction will require shipping.
		        // Dynamic Amount Calculation allows you to set tax and shipping amounts based on the user's shipping address. Shipping must be
		        // enabled for Dynamic Amount Calculation. This also requires you to create a class that implements PaymentAdjuster and Serializable.
		        //pp.setDynamicAmountCalculationEnabled(false);
		    }
		    Log.d("mainactivity: ","doinbackground init finished");
			return null;
		}
		
		@Override
	    protected void onPostExecute(final Void result) {
			Log.d("mainactivity: ","onPostExecute PayPayis null:"+PayPal.getInstance());
			progressdialog.dismiss();
			
	    	PayPalPayment payment = new PayPalPayment();
	    	payment.setCurrencyType("USD"); // Sets the currency type for this payment.
		    payment.setRecipient("ALC_1352600102_biz@gmail.com"); // Sets the recipient for the payment. This can also be a phone number.
		    payment.setSubtotal(new BigDecimal(dollaramount));// Sets the amount of the payment, not including tax and shipping amounts.
		    payment.setMemo("donation to SC2:BOA");
		    payment.setPaymentType(PayPal.PAY_TYPE_SIMPLE);// Sets the payment type. This can be PAYMENT_TYPE_GOODS, PAYMENT_TYPE_SERVICE, PAYMENT_TYPE_PERSONAL, or PAYMENT_TYPE_NONE.
		    
		    Intent intent = PayPal.getInstance().checkout(payment, MainActivity.this, new ResultDelegate());
	    	MainActivity.this.startActivityForResult(intent, 1);
	    }
    }
    
    
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
    	//BuildOrderDBManager boc;
        switch (item.getItemId()) {
            /*case R.id.menu_settings:
                Log.d("MainActivity","menuselect: settings");
                return true;
            case R.id.Menu_debugDB:
            	Log.d("MainActivity","menuselect: DebugDB");
            	boc = new BuildOrderDBManager(this);
            	Utils.PrintBuildOrderDB(boc);
            	return true;
            case R.id.Menu_adddefaultdata:
            	Log.d("MainActivity","menuselect: Add Default Data");
            	boc = new BuildOrderDBManager(this);
            	boc.addDefaultData();
            	return true;
            case R.id.Menu_addinitaldata:
            	Log.d("MainActivity","menuselect: Add Initial Data");
            	BuildOrderDBManager.loadInitialBuilds(this);
            	Log.d("MainActivity","menuselect: Add Initial Data finished");
            	
				return true;
            case R.id.Menu_deletedb:
            	Log.d("MainActivity","menuselect: Delete Database");
            	boc = new BuildOrderDBManager(this);
            	boc.deleteAllBuildOrders();
				return true;*/
				
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
