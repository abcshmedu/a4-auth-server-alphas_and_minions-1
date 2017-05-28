package edu.hm.shareit.auth.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserServiceResultTest {
     
    @Test
    public void errorMessageTest() {
        
        UserServiceResult result = UserServiceResult.OK;
        assertTrue(UserServiceResult.getMessage(result).equals("Ok."));
    }
        

}
