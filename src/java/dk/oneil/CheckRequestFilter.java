package dk.oneil;

import java.io.IOException;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.core.Response;



public class CheckRequestFilter implements ClientRequestFilter {
 
    @Override
    public void filter(ClientRequestContext requestContext)
                        throws IOException {
        if (requestContext.getHeaders().get("Client-Name") == null) {
            requestContext.abortWith(
                        Response.status(Response.Status.BAD_REQUEST)
                .entity("Client-Name header must be defined.")
                        .build());
         }
    }

   
}