package edu.hm.shareit.auth.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.json.JSONObject;

import edu.hm.shareit.auth.model.User;

public class DatabaseImpl implements IDatabase {

	private static Map<String, User> username2user;
	
	private static Map<Integer, User> token2user;
	private static int token = 1;
	
	// for testing purposes: hard coded user
	private final User testUser = new User("Bilbo", "Baggins", "baggins111", "frodo");
	
	public DatabaseImpl() {
		username2user = new HashMap<>();
		token2user = new HashMap<>();
		
		// test
		username2user.put(testUser.getUsername(), testUser);
		token2user.put(token, testUser);
	}
	
	@Override
	public Optional<User> getUser(final String username) {
	    User user = username2user.get(username);
	    Optional<User> result = Optional.empty();
	    if (user != null) {
	        result = Optional.of(user);
	    }
		return result;
	}
	
	@Override
	public boolean isReserved(final String username) {
	    Optional<User> user = getUser(username);
	    if (user.isPresent())
	        return true;
	    else
	        return false;
	}

	@Override
	public Optional<User> checkToken(final Integer token) {
		
		Optional<User> result = Optional.empty();
		
		if (token2user.containsKey(token)) {
			result = Optional.of(token2user.get(token));
		}
		
		return result;
	}

    @Override
    public void addUser(User user) {
        String usernames = "";
        //System.out.println(username2user.size());
        username2user.put(user.getUsername(), user);
        token2user.put(++token, user);
        
        // debugging
//        System.out.println(username2user.size());
//        for (Map.Entry<String, User> entry : username2user.entrySet()) {
//            usernames += " " + entry.getKey();
//        }
//        System.out.println(usernames);
    }
    
    public int getSize() {
        return username2user.size();
    }
    
    // just for testing 
    public String getUsers() {
        
        String usernames = "";
        String jsonString = "";
        System.out.println("size in getUsers called from Resource "+ username2user.size());
        for (Map.Entry<String, User> entry : username2user.entrySet()) {
            usernames += " " + entry.getKey();
            jsonString += "\n" + new JSONObject(entry.getValue()).toString();
        }
        
        
        return jsonString;
    }
    

}
