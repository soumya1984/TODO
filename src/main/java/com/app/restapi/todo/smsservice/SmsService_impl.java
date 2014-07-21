package com.app.restapi.todo.smsservice;

import java.util.HashMap;
import java.util.Map;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.SmsFactory;
import com.twilio.sdk.resource.instance.Sms;

public class SmsService_impl implements SmsService {
	 // Find your Account Sid and Token at twilio.com/user/account
	  public static final String ACCOUNT_SID = "AC9f0b038e8258ac8ff22f808c028857dd";
	  public static final String AUTH_TOKEN = "{{ auth_token }}";

	public void sendSms(String messageBody, String to, String from) {
	    TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
	    Map<String, String> params = new HashMap<String, String>();
	    // Build a filter for the SmsList
	   // List<NameValuePair> params = new ArrayList<NameValuePair>();
	    //params.add(new BasicNameValuePair("Body", "Jenny please?! I love you <3"));
	    //params.add(new BasicNameValuePair("To", "+14159352345"));
	    //params.add(new BasicNameValuePair("From", "+14158141829"));
	    params.put("Body", "will be replaced by TODO title");
	    params.put("TO", "+16508729465");
	    params.put("Body", "+16504198174");
	     
	    SmsFactory smsFactory = client.getAccount().getSmsFactory();
	    Sms sms=null;
		try {
			sms = smsFactory.create(params);
		} catch (TwilioRestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println(sms.getSid());

	}


	public void receiveSms() {
		// TODO Auto-generated method stub

	}

}
