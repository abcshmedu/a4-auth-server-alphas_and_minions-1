package edu.hm.shareit.auth.service;

import java.util.Optional;

import edu.hm.shareit.auth.data.DatabaseImpl;
import edu.hm.shareit.auth.data.IDatabase;
import edu.hm.shareit.auth.model.User;

public class UserServiceImpl implements IUserService {

    private final IDatabase database;

	public UserServiceImpl() {
		
		this.database = new DatabaseImpl();
	}
//    public UserServiceImpl(final IDatabase database) {
//        
//    	this.database = database;
//    }

	@Override
	public UserServiceResult checkToken(final Integer token) {
		
		UserServiceResult result = UserServiceResult.OK;
		
		Optional<User> user = database.checkToken(token);
		
		if (!user.isPresent()) {
			result = UserServiceResult.I_AM_A_TEAPOT;
		}
		
		return result;
	}

    @Override
    public UserServiceResult addUser(User user) {
        
        UserServiceResult result;
        if (!database.isReserved(user.getUsername())) {
            database.addUser(user);
            //System.out.println("Service getSize "+ database.getSize()); debugging
            result = UserServiceResult.OK;
        } else {
            result = UserServiceResult.USER_NAME_RESERVED;
        }
        
        return result;
    }


    // just for testing
    @Override
    public String getUsers() {
        
        return database.getUsers();
    }

}
