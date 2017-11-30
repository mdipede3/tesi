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

//http://localhost:8080/movierecsysrestful/restService/chatMessages/getChatMessage?userID=129877748&replyFunctionCall=/start&pagerankCicle=2
@Path("/propertiesRating")
public class GetPropertyRating {
//TODO Questa invece controllerà che non si va a modificare il rating di una property valutata
	@Context ServletContext servletContext;
	@GET
	@Produces({MediaType.APPLICATION_JSON, "text/json"})
	@Path("/getPropertyRating")
	public String getPropertyRating (@QueryParam("userID") String userID,
								  	@QueryParam("propertyTypeUri") String propertyTypeUri,
								  	@QueryParam("propertyUri") String propertyUri,
								  	@QueryParam("lastChange") String lastChange) throws Exception 
	{

		int user_id = Integer.parseInt(userID);	

		Map<String,String> userPropertyRatingMap = new HashMap<String, String>();
		AdaptiveSelectionController asController = new AdaptiveSelectionController();
		userPropertyRatingMap = asController.getPropertyRatingByUserAndProperty(user_id, propertyTypeUri, propertyUri, lastChange);
		
		Gson gson = new Gson();
		String json = gson.toJson("null");
		
		if (userPropertyRatingMap != null && !userPropertyRatingMap.isEmpty()) {			
	  		json = gson.toJson(userPropertyRatingMap);
		}
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));
		 		
  		System.out.print("/propertiesRating/getPropertyRating/userID=" + user_id + "/");
  		System.out.println(json);
	 
  		return json;
	}
	
}
