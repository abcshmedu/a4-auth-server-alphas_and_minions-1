package edu.hm.shareit.auth.service;

public enum UserServiceResult {

	
    OK(200),
    USER_NAME_RESERVED(800),
	I_AM_A_TEAPOT(418);
	
	private int errorNum;

	
	UserServiceResult(final int errorCode) {
		
		errorNum = errorCode;
	}
	
	public int getErrorNum() {
		
		return errorNum;
	}
	
	public static String getErrorMessage(UserServiceResult result) {
	    String message = "";
	    switch(result) {
	    case OK:
	        message = "Ok.";
	        break;
	    case USER_NAME_RESERVED:
	        message = "User name is reserved. Please chose a diffrent one.";
	        break;
	    default:
	        message = "I am a teapot.";
	        break;
	    }
	    return message;
	}

	
}
