package edu.hm.shareit.auth.service;

public enum UserServiceResult {

	
    OK(200),
	I_AM_A_TEAPOT(418);
	
	private int errorNum;

	
	UserServiceResult(final int errorCode) {
		
		errorNum = errorCode;
	}
	
	public int getErrorNum() {
		
		return errorNum;
	}

	
}
