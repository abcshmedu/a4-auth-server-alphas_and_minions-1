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
	private String pwd;
	
	public User() {
	    
	}
	
	/**
	 * @param forename
	 * @param surename
	 * @param username
	 * @param pwd
	 */
	public User(final String forename, final String surename, final String username, final String pwd) {
		this.forename = forename;
		this.surename = surename;
		this.username = username;
		this.setPwd(pwd);
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
    public String getPwd() {
        return pwd;
    }

    /**
     * @param pwd the pwt to set
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    
    @Override
    public boolean equals(final Object obj) {
    	final User user = (User)obj;
    	boolean result = true;
    	
    	if (getUsername() != user.getUsername()) {
    		return result = false;
    	}
    	
    	return result;
    }
    
    @Override
    public String toString() {
    	
    	return String.format("[ forename: %s, surename: %s, username: %s, password: %s ]", getForename(), getSurename(), getUsername(), getPwd());
    }
	
	
	
	
}
