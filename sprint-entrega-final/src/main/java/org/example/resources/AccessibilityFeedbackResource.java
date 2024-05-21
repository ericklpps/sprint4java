package org.example.resources;

import org.example.entities.AccessibilityFeedback;
import org.example.services.AccessibilityFeedbackService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("accessibility-feedback")
public class AccessibilityFeedbackResource {

    private final AccessibilityFeedbackService feedbackService;

    public AccessibilityFeedbackResource() {
        feedbackService = new AccessibilityFeedbackService();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<AccessibilityFeedback> feedbackList = feedbackService.getAll();
        return Response.ok(feedbackList).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
        AccessibilityFeedback feedback = feedbackService.get(id);
        if (feedback == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(feedback).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(AccessibilityFeedback feedback) {
        try {
            feedbackService.create(feedback);
            return Response.status(Response.Status.CREATED).entity(feedback).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, AccessibilityFeedback feedback) {
        try {
            feedbackService.update(id, feedback);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") int id) {
        try {
            feedbackService.delete(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
}