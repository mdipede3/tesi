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
@Path("/runtimeRangeFilter")
public class PutRuntimeRangeFilter {
	
	@Context ServletContext servletContext;
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("/putRuntimeRangeFilter")
	public String putPropertyRating(	@QueryParam("userID") String userID,
												@QueryParam("propertyType") String propertyType,
							   				@QueryParam("propertyValue") String propertyValue) throws Exception 
	{
		int user_id = Integer.parseInt(userID);
		String runtimeRangeFilter = null;
		AdaptiveSelectionController asController = new AdaptiveSelectionController();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));

		if (propertyType.equals("runtimeRange")) {
			runtimeRangeFilter = asController.changeRuntimeRangeStringToRuntimeRangeValue(propertyValue);				
		}			
		
		if (!runtimeRangeFilter.equalsIgnoreCase(null)) {
			//System.out.println("Run...insertPropertyRatedByUser userID: " + user_id + " propertyURI:" + propertyURI);
			asController.putRuntimeRangeFilterByUser(user_id, propertyType, runtimeRangeFilter);
			asController.putLastChange(user_id, "property_rating");
		}
		else {
			System.err.println("Error - putRuntimeRangeFilter userID: " + user_id + " - propertyValue:" + propertyValue + " - runtimeRangeFilter:" + runtimeRangeFilter);
		}
			
		Gson gson = new Gson();
		String json = gson.toJson("null");
		json = gson.toJson(runtimeRangeFilter);			

		System.out.print("/putRuntimeRangeFilter?userID=" + userID + "&propertyType=" + propertyType + "&propertyValue=" + propertyValue + "/");

		System.out.println(json);
		
		return json;		
	}	
}






