package edu.hm.shareit.auth.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.ValueNode;

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
	
//	public UserResource(final IUserService service) {
//		
//		this.service = service;
//	}

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
    	
    	return Response.status(result.getErrorNum()).entity(jsonString).build();
    }

    
  
}
