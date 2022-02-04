package br.com.gptw.registration.api.model;

public class SmsRequest {

    private String phoneNumber; // destination

    private String message;


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMessage() {
        return message;
    }
    
    
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public SmsRequest(String phoneNumber, String message) {
		this.phoneNumber = phoneNumber;
		this.message = message;
		
		// TODO Auto-generated constructor stub
	}

   
    
}