package edu.hm.edu.shareit.auth.resource;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;

import org.junit.Test;

import edu.hm.shareit.auth.resource.UserResource;

import static org.junit.Assert.assertEquals;

public class MyResourceTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(UserResource.class);
    }

    /**
     * Test to see that the message "Got it!" is sent in the response.
     */
    @Test
    public void testGetIt() {
        final String responseMsg = target().path("myresource").request().get(String.class);

        assertEquals("Hello, Heroku!", responseMsg);
    }
}
