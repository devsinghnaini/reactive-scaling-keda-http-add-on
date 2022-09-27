package org.acme.resource;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.faulttolerance.Timeout;



import io.smallrye.common.annotation.NonBlocking;
import io.smallrye.mutiny.Uni;

@Path("/query")
public class RestResource {

    private static final String responseJson="Hello World Quarkus Rest Server";


    @GET
    @Timeout(value = 4000)
    @NonBlocking
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Response> handleGetRequest() {
        
        return Uni.createFrom().item(Response.accepted(responseJson).build())
        .onFailure().recoverWithItem(Response.serverError().build());

    }

}
