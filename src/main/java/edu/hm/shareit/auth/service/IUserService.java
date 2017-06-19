package edu.hm.shareit.auth.service;

import java.util.Optional;

import edu.hm.shareit.auth.model.LoginDetails;
import edu.hm.shareit.auth.model.User;

public interface IUserService {
	
	/**
	 * check if token is valid
	 * @param token
	 * @return
	 */
	public UserServiceResult checkToken(final Integer token);

    /**
     * add a user
     * @param user
     * @return
     */
    UserServiceResult addUser(User user);

    /**
     * check if user login is valid
     * @param login
     * @return
     */
    public Optional<Integer> validateUser(LoginDetails login);
	
	
}
