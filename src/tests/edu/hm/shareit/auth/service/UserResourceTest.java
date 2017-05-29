package edu.hm.shareit.auth.service;

import static org.junit.Assert.*;

import javax.ws.rs.core.Response;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.hm.shareit.auth.model.LoginDetails;
import edu.hm.shareit.auth.resource.UserResource;

public class UserResourceTest {

//    public UserResourceTest() {
//        // TODO Auto-generated constructor stub
//    }
//
//    @Test
//    public void validateUserTest() throws JsonProcessingException {
//        
//        UserResource resource = new UserResource();
//        
//        LoginDetails login = new LoginDetails("baggins111","frodo");
//        
//        Response response = resource.validateUser(login);
//        
//        ObjectMapper mapper = new ObjectMapper();
//        String jsonString = mapper.writeValueAsString(UserServiceResult.getMessage(UserServiceResult.OK));
//        
//        assertEquals(response.getEntity().toString(), jsonString);
//        
//        LoginDetails loginInvalid = new LoginDetails("baggins111","FRODO");
//        jsonString = mapper.writeValueAsString(UserServiceResult.getMessage(UserServiceResult.I_AM_A_TEAPOT));
//        
//        response = resource.validateUser(loginInvalid);
//        assertEquals(response.getEntity().toString() , jsonString);
//        
//    }
//    
}
