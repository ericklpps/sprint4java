package org.example.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.entities.AccessibilityConfig;
import org.example.services.AccessibilityConfigService;

@Path("accessibility-config")
public class AccessibilityConfigResource {

    private final AccessibilityConfigService configService;

    public AccessibilityConfigResource() {
        configService = new AccessibilityConfigService();
    }

    @GET
    @Path("{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("userId") int id) {
        AccessibilityConfig config = configService.findByUserId(id);
        if (config == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            return Response.ok(config).build();
        }
    }

    @PUT
    @Path("{userId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("userId") int id, AccessibilityConfig config) {
        try {
            configService.update(id, config);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
}