package edu.hm.shareit.auth.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.json.JSONObject;
import org.junit.runners.Parameterized.Parameter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ValueNode;

import edu.hm.shareit.auth.model.LoginDetails;
import edu.hm.shareit.auth.model.User;
import edu.hm.shareit.auth.service.IUserService;
import edu.hm.shareit.auth.service.UserServiceImpl;
import edu.hm.shareit.auth.service.UserServiceResult;


/**
 * Root resource (exposed at "auth" path)
 */
@Path("auth")
public class UserResource {
	
	private final IUserService service;
	
	public UserResource() {
		service = new UserServiceImpl();
	}
	

    public IUserService getService() {
		return service;
	}

	/**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Hello, Heroku!";
    }
    
    @GET
    @Produces("application/json")
    @Path("users/{token}")
    public Response checkToken( @PathParam("token") final Integer token ) throws JsonProcessingException {
    	
    	UserServiceResult result = service.checkToken(token);
    	ObjectMapper mapper = new ObjectMapper();
    	
    	String jsonString = mapper.writeValueAsString(result.getErrorNum());
    	
    	return Response.status(200).entity(jsonString).build();
    }
    
    @POST
    @Path("users/register")
    @Consumes("application/json")
    @Produces("application/json")
    public Response addUser(final User user) throws JsonProcessingException {
        UserServiceResult result = service.addUser(user);

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(UserServiceResult.getMessage(result));
        return Response.status(200).entity(jsonString).build();
    }
    
    @POST
    @Path("users/login")
    @Consumes("application/json")
    @Produces("application/json")
    public Response validateUser(LoginDetails login) throws JsonProcessingException, URISyntaxException {
        Optional<Integer> result = service.validateUser(login);
        
        String httpURI = "http://localhost:8080/";
        int token = -1;
        if (result.isPresent()) {
            token = result.get();
        }
        
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(token);
        
        URI redirectURI = new URI(httpURI);
        return Response.temporaryRedirect(redirectURI).entity(jsonString).status(200).build();
    }
  
}
