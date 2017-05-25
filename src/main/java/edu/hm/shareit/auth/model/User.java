package edu.hm.shareit.auth.model;

public class User {

	private final String forename;
	
	private final String surename;
	
	private final String username;
	
	public User(final String forename, final String surename, final String username) {
		this.forename = forename;
		this.surename = surename;
		this.username = username;
	}

	public String getForename() {
		return forename;
	}

	public String getSurename() {
		return surename;
	}

	public String getUsername() {
		return username;
	}
	
	
	
	
}
