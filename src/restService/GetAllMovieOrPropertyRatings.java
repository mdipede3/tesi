package restService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import graph.AdaptiveSelectionController;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

//http://localhost:8080/movierecsysrestful/restService/posNegRatings/getAllMovieOrPropertyRatings?userID=6
@Path("/posNegRatings")
public class GetAllMovieOrPropertyRatings {
	//TODO Questa ci servirà per modificare le property che l'utente ha indicato nelle preferenze, è tutto da fare
	
	
	
	@Context ServletContext servletContext;
	@GET
	@Produces({MediaType.APPLICATION_JSON, "text/json"})
	@Path("/getAllMovieOrPropertyRatings")
	public String getAllMovieOrPropertyRatings (@QueryParam("userID") String userID) throws Exception 
	{
		int user_id = Integer.parseInt(userID);
		AdaptiveSelectionController asController = new AdaptiveSelectionController();
		Map<String, Integer> movieOrPropertyToRatingMap = new HashMap<String, Integer>();
		movieOrPropertyToRatingMap = asController.getPosNegRatingForUserFromRatings(user_id);
		
		Gson gson = new Gson();
		String json = gson.toJson("null");
		//movieOrPropertyToRatingMap != null && !movieOrPropertyToRatingMap.isEmpty()
		if (movieOrPropertyToRatingMap != null && !movieOrPropertyToRatingMap.isEmpty()) {			
	  		json = gson.toJson(movieOrPropertyToRatingMap);
		}
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));
		
  		System.out.print("/posNegRatings/getAllMovieOrPropertyRatings/");
  		System.out.println(json);
  		
  		return json;
  		
  		//{"http://dbpedia.org/resource/Leonardo_DiCaprio,http://dbpedia.org/ontology/producer":1,"http://dbpedia.org/resource/Ben_Stiller,http://dbpedia.org/ontology/starring":0,"http://dbpedia.org/resource/Leonardo_DiCaprio,http://dbpedia.org/ontology/starring":1,"http://dbpedia.org/resource/Inception,movie":1,"http://dbpedia.org/resource/Forrest_Gump,movie":0}
	}

}
