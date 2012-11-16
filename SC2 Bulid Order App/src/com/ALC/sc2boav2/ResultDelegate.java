package com.ALC.sc2boav2;
import java.io.Serializable;

import java.io.Serializable;

import com.paypal.android.MEP.PayPalResultDelegate;

/*
 * Our PayPalListener class to get the device reference token from MECL
 */
public class ResultDelegate implements PayPalResultDelegate, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1046928519612693345L;


	public void onPaymentSucceeded(String payKey, String paymentStatus) {

        //DonationActivity.resultTitle = "SUCCESS";
        //DonationActivity.resultInfo = "You have successfully completed your transaction.";
        //DonationActivity.resultExtra = "Key: " + payKey;
    }


    public void onPaymentFailed(String paymentStatus, String correlationID,
                  String payKey, String errorID, String errorMessage) {
        //DonationActivity.resultTitle = "FAILURE";
        //DonationActivity.resultInfo = errorMessage;
        //DonationActivity.resultExtra = "Error ID: " + errorID + "\nCorrelation ID: "
        //   + correlationID + "\nPay Key: " + payKey;
    }


    public void onPaymentCanceled(String paymentStatus) {
        //DonationActivity.resultTitle = "CANCELED";
        //DonationActivity.resultInfo = "The transaction has been cancelled.";
        //DonationActivity.resultExtra = "";
    }


	

}
