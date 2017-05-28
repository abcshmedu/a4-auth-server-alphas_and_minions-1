package edu.hm.shareit.auth.service;

import java.util.Optional;

import edu.hm.shareit.auth.model.LoginDetails;
import edu.hm.shareit.auth.model.User;

public interface IUserService {
	
	public UserServiceResult checkToken(final Integer token);

	// just for testing
    String getUsers();

    UserServiceResult addUser(User user);

    public UserServiceResult validateUser(LoginDetails login);
	
	
}
