package edu.hm.shareit.auth.data;

import java.util.Optional;

import edu.hm.shareit.auth.model.LoginDetails;
import edu.hm.shareit.auth.model.User;

public interface IDatabase {

	/*
	 * returns user according to username if available, empty otherwise.
	 * only for internal purposes.
	 */
	public Optional<User> getUser(final String username);
	
	/**
	 * Returns user according to token, empty otherwise.
     * Used for other services to authenticate.
	 * @param token
	 * @return
	 */
	public Optional<User> checkToken(final int token);
	
    /**
     * checks if username is reserved
     * @param username
     * @return
     */
    boolean isReserved(final String username);
    
    /*
     * Adds a new user if possible
     */
    public boolean addUser(final User user);

    /**
     * checks if login is valid
     * @param login
     * @return
     */
    public Optional<Integer> isValid(LoginDetails login);
	
}
