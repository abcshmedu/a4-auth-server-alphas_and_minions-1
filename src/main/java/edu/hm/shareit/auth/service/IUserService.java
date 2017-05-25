package edu.hm.shareit.auth.service;

import java.util.Optional;

import edu.hm.shareit.auth.model.User;

public interface IUserService {

	
	public UserServiceResult addUser(final User user);
	
	public UserServiceResult checkToken(final Integer token);
	
	
}
