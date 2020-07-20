package com.arului;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.SseElementType;
import org.jboss.resteasy.annotations.jaxrs.PathParam;


@Path ("/reactive-demo")
public class ReactiveDemoService {

    @Inject
    ReactiveDemo reactiveDemo;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path ("/single")
    public Response getReactiveDemoCall( @PathParam String name){
        Uni<String> uniString = reactiveDemo.getReactiveDemoCall (name);
        return Response.ok (uniString).build ();

    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/greeting/{count}/{name}")
    public Multi<String> greetings( @PathParam int count, @PathParam String name) {
        return reactiveDemo.getReactiveDemoMulti (count, name);
    }
}
