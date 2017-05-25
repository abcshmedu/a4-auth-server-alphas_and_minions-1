package edu.hm.shareit.auth.data;

import java.util.Optional;

import edu.hm.shareit.auth.model.User;

public interface IDatabase {

	
	public User getUser(final String username);
	
	public Optional<User> checkToken(final Integer token);
	
	
}
