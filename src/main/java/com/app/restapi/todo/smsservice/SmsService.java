package com.app.restapi.todo.smsservice;

public interface SmsService {
	public void sendSms(String messageBody,String to,String from);
	public void receiveSms();
	

}
