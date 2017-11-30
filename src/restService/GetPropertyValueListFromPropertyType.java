package restService;

import graph.AdaptiveSelectionController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


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

//http://localhost:8080/movierecsysrestful/restService/propertyValueList/getPropertyValueListFromPropertyType?userID=6&propertyType=director
//http://localhost:8080/movierecsysrestful/restService/propertyValueList/getPropertyValueListFromPropertyType?userID=6&propertyType=movie
@Path("/propertyValueList")
public class GetPropertyValueListFromPropertyType {

	@Context ServletContext servletContext;
	@GET
	@Produces({MediaType.APPLICATION_JSON, "text/json"})
	@Path("/getPropertyValueListFromPropertyType")
	public String getPropertyValueListFromPropertyType( @QueryParam("userID") String userID,
						   								@QueryParam("propertyType") String propertyType) throws Exception 
	{
		int user_id = Integer.parseInt(userID);
		Map<Double, String> propertyMap = new HashMap<Double, String>();
		AdaptiveSelectionController asController = new AdaptiveSelectionController();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));

		String lastChange = asController.getLastChange(user_id);
		
		//controllo per esegue il pagerank solo se c'è stato un cambiamento
		boolean check = true;
		if (lastChange.equals("pagerank") || lastChange.equals("refine")) {
			check = false;
		}
		
		//con propertyType = movie parte il pagerank per aggiornare la lista dei film raccomandati
		//if (propertyType.equals("movie") && (!lastChange.equals("pagerank") || !lastChange.equals("refine"))) {
		if ( (propertyType.equals("movie") && check == true) ) {
			//System.out.println("/getPropertyValueListFromPropertyType - Run PageRank - user_id: " + user_id + " propertyType:" + propertyType + " - lastChange: " + lastChange);
			asController.createGraphAndRunPageRank(user_id);
			propertyMap = asController.getPropertyValueListMapFromPropertyType(user_id, propertyType);
		}
		else {
			//System.out.println("/getPropertyValueListFromPropertyType - user_id: " + user_id + " propertyType:" + propertyType + " - lastChange: " + lastChange);
			propertyMap = asController.getPropertyValueListMapFromPropertyType(user_id, propertyType);
			
			//se non ritrovo le proprietà rilanciavo il pagerank ma crea dei loop... meglio che c ritorni null
/*						if (propertyMap.isEmpty() == true) {
				
				//System.out.println("/getPropertyValueListFromPropertyType - propertyMap.isEmpty() - Run PageRank - user_id: " + user_id + " propertyType:" + propertyType + " - lastChange: " + lastChange);
		    	asController.createGraphAndRunPageRank(user_id);
		    	propertyMap = asController.getPropertyValueListMapFromPropertyType(user_id, propertyType);
			}*/
		}	
		
		Gson gson = new Gson();
		String json = gson.toJson("null");
		
		if (propertyMap != null && !propertyMap.isEmpty()) {			
			json = gson.toJson(propertyMap);
		}
		 
		System.out.print("/getPropertyValueListFromPropertyType?userID=" + userID + "&propertyType=" + propertyType + " - lastChange: " + lastChange + "/");
		if (json.equals("null")) {
			System.out.println(json);
		}
		else {
			System.out.println("ok");
		}
		
			 
		return json;
	}

}