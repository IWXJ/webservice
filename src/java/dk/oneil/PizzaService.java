package dk.oneil;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/service")
public class PizzaService {
	
	@GET
	@Path("/getPizzas")
	@Produces({MediaType.TEXT_XML, MediaType.APPLICATION_XML})
	public List<Pizza> getPizzas(@QueryParam("min") double min, @QueryParam("max") double max) {
		List<Pizza> pizzaList = createPizzaList();
		List<Pizza> pizzaListFiltered = filterPizzaList(pizzaList, min, max);
		
		return pizzaListFiltered;
	}

	private List<Pizza> createPizzaList() {
		List<Pizza> pizzaList = new ArrayList<Pizza>();
		pizzaList.add(new Pizza("Mambo", "Great and tasty.", 23.87));
		pizzaList.add(new Pizza("Tomatocut", "Sweet and juicy.", 38.87));
		pizzaList.add(new Pizza("Cheapy", "Nasty but does the trick.", 8.87));
		return pizzaList;
	}
	
	private List<Pizza> filterPizzaList(List<Pizza> pizzaList, double min, double max) {
		List<Pizza> pizzaListFiltered = new ArrayList<Pizza>();
		
		for (Pizza pizza : pizzaList) {
			double price = pizza.getPrice();
			
			if(price >= min && price <= max) {
				pizzaListFiltered.add(pizza);
			}
		}
		
		return pizzaListFiltered;
	}
        
        	
}
