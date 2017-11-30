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

//http://localhost:8080/movierecsysrestful/restService/runtimeRangeFilter/putRuntimeRangeFilter?userID=6&propertyType=runtimeRange&propertyValue=runtime 90 - 120 min
@Path("/usedRecommenderSystems")
public class PutUserUsedRecommenderSystems {
	
	@Context ServletContext servletContext;
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("/putUserUsedRecommenderSystems")
	public String putUserUsedRecommenderSystems(@QueryParam("userID") String userID,
												@QueryParam("usedRecSys") String usedRecSys) throws Exception 
	{
		int user_id = Integer.parseInt(userID);
		
		AdaptiveSelectionController asController = new AdaptiveSelectionController();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));

		if (usedRecSys != null && !usedRecSys.isEmpty()) {
			asController.putUsedRecSysByUser(user_id, usedRecSys);
		}
		else {
			System.err.println("Error - putUserUsedRecommenderSystems userID: " + user_id + " - usedRecSys:" + usedRecSys);
		}
			
		Gson gson = new Gson();
		String json = gson.toJson("null");
		json = gson.toJson(usedRecSys);			

		System.out.print("/putUserUsedRecommenderSystems?userID=" + userID + "&usedRecSys=" + usedRecSys + "/");
		System.out.println(json);
		
		return json;		
	}	
}