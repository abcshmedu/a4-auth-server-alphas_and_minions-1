package edu.hm.shareit.auth.model;

/**
 * @author Rebecca Brydon
 * @author Michael Eggers
 *
 */
public class User {

	private String forename;
	private String surename;
	private String username;
	private String pwt;
	
	public User() {
	    
	}
	
	/**
	 * @param forename
	 * @param surename
	 * @param username
	 * @param pwt
	 */
	public User(final String forename, final String surename, final String username, final String pwt) {
		this.forename = forename;
		this.surename = surename;
		this.username = username;
		this.setPwt(pwt);
	}

	/**
	 * @return
	 */
	public String getForename() {
		return forename;
	}

	/**
	 * @return
	 */
	public String getSurename() {
		return surename;
	}

	/**
	 * @return
	 */
	public String getUsername() {
		return username;
	}

    /**
     * @return the pwt
     */
    public String getPwt() {
        return pwt;
    }

    /**
     * @param pwt the pwt to set
     */
    public void setPwt(String pwt) {
        this.pwt = pwt;
    }
	
	
	
	
}
