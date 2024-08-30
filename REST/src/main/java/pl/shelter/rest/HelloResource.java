package pl.shelter.rest;

import jakarta.ws.rs.*;


@Path("/hello-world")
public class HelloResource {
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }
}