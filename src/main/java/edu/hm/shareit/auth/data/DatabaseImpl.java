package edu.hm.shareit.auth.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import org.json.JSONObject;

import edu.hm.shareit.auth.model.LoginDetails;
import edu.hm.shareit.auth.model.User;

/**
 * Simple Database.
 * Note that users get stored two times. Bad!
 * 
 * @author Michael Eggers
 * @author Rebecca Brydon
 *
 */
public class DatabaseImpl implements IDatabase {

	private static Map<String, User> username2user = new HashMap<>();
	
	private static Map<Integer, User> token2user = new HashMap<>();
	
	private static int token = 0;
	
//	// for testing purposes: hard coded user
//	private final User testUser = new User("Bilbo", "Baggins", "baggins111", "frodo");
////	
//	int dummy = initTests();
//	
//	int initTests() {
//		username2user.put(testUser.getUsername(), testUser);
//		token2user.put(token, testUser);
//		
//		return 42;
//	}

	
	public DatabaseImpl() {
		// initTests();
	}
	
	@Override
	public Optional<User> getUser(final String username) {
	    final User user = username2user.get(username);
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
	public Optional<User> checkToken(final int token) {
		
		Optional<User> result = Optional.empty();
		
		if (token2user.containsKey(token)) {
			result = Optional.of(token2user.get(token));
		}

		return result;
	}

    @Override
    public boolean addUser(final User user) {
    	boolean result = false;
    	boolean found = username2user.containsKey(user.getUsername());
    	
    	if (!found) {
    		username2user.put(user.getUsername(), user);
    		token2user.put(++token, user);
    		result = true;
    	}
    	
    	return result;
    }
    
    public int getSize() {
        return username2user.size();
    }
    
    // just for testing 
    public String getUsers() {
        
        String usernames = "";
        String jsonString = "";
        System.out.println("Number of users="+ username2user.size());
        for (Map.Entry<String, User> entry : username2user.entrySet()) {
            usernames += " " + entry.getKey();
            jsonString += "\n" + new JSONObject(entry.getValue()).toString();
        }
        
        
        return jsonString;
    }
    
    // NEW
    private Optional<Integer> getToken4User(User user){
        Optional result = Optional.empty();
        for (Entry<Integer, User> entry : token2user.entrySet()) {
            if (entry.getValue().equals(user)) {
                result = Optional.of(entry.getKey());
                return result;
            }
        }
        return result;
    }

    // NEW checks if login details exist and are valid
    @Override
    public Optional<Integer> isValid(LoginDetails login) {
        
        Optional<Integer> result = Optional.empty();
        if (username2user.containsKey(login.getUsername())) {
            User check = username2user.get(login.getUsername());
            if (check.getPwd().equals(login.getPassword())) {
                
                Optional<Integer> token = getToken4User(check);
                if (token.isPresent()) {
                    result = Optional.of(token.get());
                }
            }
        }
        return result;
    }
    

}
