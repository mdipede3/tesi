package restService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
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
/**
 * Tra i film raccomandabili per l'utente (userID)
 * Seleziona i valori delle proprieta' di un certo tipo, es. regista
 * Oppure selezione tutti i film raccomandabili in base allo score
 */

//http://localhost:8080/movierecsysrestful/restService/property?userID=6&propertyType=director

//http://localhost:8080/movierecsysrestful/restService/propertyValueListAndMovie/getPropertyValueFromPropertyTypeAndMovie?userID=6&propertyType=releaseYear
//http://localhost:8080/movierecsysrestful/restService/propertyValueListAndMovie/getPropertyValueFromPropertyTypeAndMovie?userID=6&propertyType=movie

/**
 * Tra i film raccomandabili per l'utente (userID)
 * Seleziona i valori delle proprieta' di un certo tipo, es. regista
 * Oppure selezione tutti i film raccomandabili in base allo score
 */
@Path("/recMovieTopropertyValueAndScoreList")
public class GetPropertyValueFromPropertyTypeAndMovie {

	@Context ServletContext servletContext;
	@GET
	@Produces({MediaType.APPLICATION_JSON, "text/json"})
	@Path("/getPropertyValueAndScoreListByRecMovieFromUserAndPropertyType")
	public String getPropertyValueAndScoreListByRecMovieFromUserAndPropertyType(@QueryParam("userID") String userID,
						   							@QueryParam("propertyType") String propertyType) throws Exception 
	{
		int user_id = Integer.parseInt(userID);
		AdaptiveSelectionController asController = new AdaptiveSelectionController();
		Map<String, List<String>> propertyMap = new HashMap<String, List<String>>();

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));
		
		String lastChange = asController.getLastChange(user_id);
		//System.out.println("/getPropertyValueFromPropertyTypeAndMovie - user_id: " + user_id + " propertyType:" + propertyType + " - lastChange: " + lastChange);
		
		if (propertyType.equals("movie") &&  (!lastChange.equals("pagerank")|| !lastChange.equals("refine"))) {	
			//System.out.println("/getPropertyValueFromPropertyTypeAndMovie - Find Movie - Run PageRank - user_id: " + user_id + " propertyType:" + propertyType+ " - lastChange: " + lastChange);
			asController.createGraphAndRunPageRank(user_id);
			propertyMap = asController.getPropertyValueAndScoreListByRecMovieFromUserAndPropertyType(user_id, propertyType);
      		
		} else {
			//System.out.println("/getPropertyValueFromPropertyTypeAndMovie - Find Property - user_id: " + user_id + " propertyType:" + propertyType);
			propertyMap = asController.getPropertyValueAndScoreListByRecMovieFromUserAndPropertyType(user_id, propertyType);
	      
			//evito il loop
/*			if (propertyMap.isEmpty() == true && !propertyType.equals("releaseYear") && !propertyType.equals("runtimeRange")) {
		    	//System.out.println("/getPropertyValueFromPropertyTypeAndMovie - Find Property - Run PageRank - user_id: " + user_id + " propertyType:" + propertyType);
	      	asController.createGraphAndRunPageRank(user_id);
	      	propertyMap = asController.getPropertyValueAndScoreListByRecMovieFromUserAndPropertyType(user_id, propertyType);
			}
			*/
		}	
		
		Gson gson = new Gson();
		String json = gson.toJson("null");
		
		if (propertyMap != null && !propertyMap.isEmpty()) {			
			json = gson.toJson(propertyMap);
		}
		 
		System.out.print("/getPropertyValueFromPropertyTypeAndMovie?userID=" + user_id + "&propertyType=" + propertyType +"/");
		if (json.equals("null")) {
			System.out.println(json);
		}
		else {
			System.out.println("ok");
		}
			 
		return json;
	}

}