package edu.hm.shareit.auth.data;

import java.util.Optional;

import edu.hm.shareit.auth.model.User;

public interface IDatabase {

	
	public Optional<User> getUser(final String username);
	
	public Optional<User> checkToken(final Integer token);

    boolean isReserved(final String username);
    
    public void addUser(User user);

    
    // just for testing
    public String getUsers();
	public int getSize();
	
}
