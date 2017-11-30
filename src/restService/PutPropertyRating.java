package restService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import graph.AdaptiveSelectionController;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

//http://localhost:8080/movierecsysrestful/restService/propertyRating/putPropertyRating?userID=6&propertyTypeURI=http://dbpedia.org/ontology/starring&propertyURI=http://dbpedia.org/resource/Ben_Stiller&rating=0&lastChange=user
//http://localhost:8080/movierecsysrestful/restService/propertyRating/putPropertyRating?userID=6&propertyTypeURI=http://dbpedia.org/ontology/starring&propertyURI=http://dbpedia.org/resource/Leonardo_DiCaprio&rating=1&lastChange=user
@Path("/propertyRating")
public class PutPropertyRating {
	
	@Context ServletContext servletContext;
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("/putPropertyRating")
	public String putPropertyRating(@QueryParam("userID") String userID,
									@QueryParam("propertyTypeURI") String propertyTypeURI,
							   		@QueryParam("propertyURI") String propertyURI,
							   		@QueryParam("rating") String rating,
							   		@QueryParam("lastChange") String lastChange) throws Exception 
	{
		int user_id = Integer.parseInt(userID);
		Integer r = Integer.parseInt(rating);

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));

		AdaptiveSelectionController asController = new AdaptiveSelectionController();

		if (!propertyTypeURI.equals("runtimeRange") || !propertyTypeURI.equals("releaseYear") ) {
			propertyTypeURI = asController.getResourceUriFromDbpediaMoviesSelection(propertyTypeURI);		//controllo l'esistenza delle property
			propertyURI = asController.getResourceUriFromDbpediaMoviesSelection(propertyURI);				//e risolvo il problema del case_sensitive
		}	
		
		int numberRatedProperties;
		
		if (!propertyTypeURI.equalsIgnoreCase("null") && !propertyURI.equalsIgnoreCase("null")) {
			asController.putPropertyRatedByUser(user_id,propertyTypeURI, propertyURI, r, lastChange);
			if (r.equals(1) || r.equals(2) ) {
				asController.putLastChange(user_id, "property_rating");
			}
			
		}
		else {
			System.err.println("Error - putPropertyRating userID: " + user_id + " propertyURI:" + propertyURI);
		}
		numberRatedProperties = asController.getNumberRatedProperties(user_id);				
		
		Gson gson = new Gson();
		String json = gson.toJson("null");
		json = gson.toJson(numberRatedProperties);		
		
		System.out.print("/putPropertyRating?userID=" + userID  + "&propertyTypeURI=" + propertyTypeURI + "&propertyURI=" + propertyURI + "&rating=" + rating +"/");
		System.out.println(json);
		
		return json;		
	}	
}






