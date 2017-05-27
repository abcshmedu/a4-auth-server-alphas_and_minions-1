package edu.hm.shareit.auth.service;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.hm.shareit.auth.model.User;

public class UserServiceImplTest {

    private final User testUser2 = new User("Frodo", "Baggins", "hobbington4ever", "gandalf");
    
    @Test
    public void userTest() {
        
        UserServiceImpl service = new UserServiceImpl();
        
        UserServiceResult result = service.addUser(testUser2);
        
        assertEquals("Ok.", UserServiceResult.getErrorMessage(result) );
        assertEquals(service.getUsers(), "\n{\"forename\":\"Frodo\",\"surename\":\"Baggins\",\"pwt\":\"gandalf\",\"username\":\"hobbington4ever\"}"
                + "\n{\"forename\":\"Bilbo\",\"surename\":\"Baggins\",\"pwt\":\"frodo\",\"username\":\"baggins111\"}");
        
        result = service.addUser(testUser2);
        assertEquals(UserServiceResult.USER_NAME_RESERVED, result);
        
    }

}
