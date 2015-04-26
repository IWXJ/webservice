
package dk.oneil;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import org.glassfish.jersey.client.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;


/**
 *
 * @author peter
 */
@Path("/service2")
public class PizzaClient {
    
    @GET
    @Path("/getRemotePizzas")
    @Produces({MediaType.TEXT_XML, MediaType.APPLICATION_XML})
    public String PizzaClient () {
//   public List<Pizza> PizzaClient (@QueryParam("min") double min, @QueryParam("max") double max) {
        Client client = ClientBuilder.newClient(new ClientConfig());
        String entity = client.target("http://3.ospoapp.appspot.com/rest/service")
            .path("/getPizzas")
            .queryParam("min", "5.23")
            .queryParam("max", "45.43")
            .request(MediaType.TEXT_PLAIN_TYPE)
            .header("some-header", "true")
            .get(String.class);

        System.out.println("And the reply was: "+entity);
  
                    
        
        List<Pizza> pizzaList = new ArrayList<Pizza>();   // this will be replaced by the collected pizza list
        pizzaList.add(new Pizza("xx", "Great and tasty.", 23.87));
        pizzaList.add(new Pizza("xx", "Sweet and juicy.", 38.87));
	pizzaList.add(new Pizza("xx", "Nasty but does the trick.", 8.87));
//        return pizzaList;
        
        
        return entity;
    }

}


        
        
 