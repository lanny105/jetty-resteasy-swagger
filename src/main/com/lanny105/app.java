package com.lanny105;



import io.swagger.annotations.*;

import javax.servlet.http.HttpServlet;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Api(value = "/", description = "Query about username")
@Path("/")
public class app {
    @GET
    @Path("/hello")
    @Produces("application/json")
    @ApiOperation(value = "get username", notes = "Get username", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid parameter supply",
                    responseHeaders = @ResponseHeader(name = "X-Rack-Cache", description = "Explains whether or not a cache was used", response = Boolean.class)),
            @ApiResponse(code = 404, message = "Page not found") })

    public Response getPara(@ApiParam(value = "username for query") @QueryParam("username") String info) {

        if (info == null) return Response.status(400).build();

        return Response.status(200).entity("{\"response\":\"Hello World " + info+ "\"}").build();

    }
}