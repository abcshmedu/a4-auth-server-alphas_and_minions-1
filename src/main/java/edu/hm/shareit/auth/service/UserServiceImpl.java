package edu.hm.shareit.auth.service;

import java.util.Optional;

import edu.hm.shareit.auth.data.DatabaseImpl;
import edu.hm.shareit.auth.data.IDatabase;
import edu.hm.shareit.auth.model.User;

public class UserServiceImpl implements IUserService {

	final IDatabase database;

	public UserServiceImpl() {
		
		database = new DatabaseImpl();
	}
//    public UserServiceImpl(final IDatabase database) {
//        
//    	this.database = database;
//    }

	@Override
	public UserServiceResult addUser(final User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserServiceResult checkToken(final Integer token) {
		
		UserServiceResult result = UserServiceResult.OK;
		
		Optional<User> user = database.checkToken(token);
		
		if (!user.isPresent()) {
			result = UserServiceResult.I_AM_A_TEAPOT;
		}
		
		return result;
	}

}
