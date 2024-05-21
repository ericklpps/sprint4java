package org.example.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import org.example.entities.AccessibilityConfig;
import org.example.entities.User;
import org.example.entities.dtos.UserDTO;
import org.example.services.AccessibilityConfigService;
import org.example.services.UserService;

import java.util.List;

/**
 * Root resource (exposed at "users" path)
 */
@Path("users")
public class UserResource {

    private final UserService userService;
    private final AccessibilityConfigService accessibilityConfigService;

    public UserResource() {
        userService = new UserService();
        accessibilityConfigService = new AccessibilityConfigService();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<User> users = userService.findAll();
        return Response.ok(users).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
        User user = userService.findById(id);
        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(user).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(UserDTO user) {
        try {
            User newUser = new User(user.getPassword(), user.getBirthday(), user.getEmail(), user.getLastName(), user.getName());
            userService.create(newUser);
            AccessibilityConfig config = new AccessibilityConfig(newUser.getId(), user.isColorBlind());
            accessibilityConfigService.create(config);
            return Response.status(Response.Status.CREATED).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, User user) {
        try {
            userService.update(id, user);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") int id) {
        try {
            accessibilityConfigService.deleteByUserId(id);
            userService.delete(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
}
