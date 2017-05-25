package edu.hm.shareit.auth.data;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import edu.hm.shareit.auth.model.User;

public class DatabaseImpl implements IDatabase {

	private static Map<String, User> username2user;
	
	private static Map<Integer, User> token2user;
	
	// for testing purposes: hard coded user
	private final User testUser = new User("Bilbo", "Beutlin", "bbeutlin");
	
	public DatabaseImpl() {
		username2user = new HashMap<>();
		token2user = new HashMap<>();
		
		// test
		username2user.put(testUser.getUsername(), testUser);
		token2user.put(1, testUser);
	}
	
	@Override
	public User getUser(final String username) {

		return username2user.get(username);
	}

	@Override
	public Optional<User> checkToken(final Integer token) {
		
		Optional<User> result = Optional.empty();
		
		if (token2user.containsKey(token)) {
			result = Optional.of(token2user.get(token));
		}
		
		return result;
	}

}
