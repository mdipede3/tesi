package restService;

import java.net.URLDecoder;
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

//http://localhost:8080//movierecsysrestful/restService/releaseYearFilter/putReleaseYearFilter?userID=6&propertyType=releaseYear&propertyValue=1980s - 2000s
//http://localhost:8080/movierecsysrestful/restService/releaseYearFilter/putReleaseYearFilter?userID=129877748&propertyType=releaseYear&propertyValue=1980s%20-%202000s
@Path("/releaseYearFilter")
public class PutReleaseYearFilter {
	
	@Context ServletContext servletContext;
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("/putReleaseYearFilter")
	public String putPropertyRating(@QueryParam("userID") String userID,
									@QueryParam("propertyType") String propertyType,
							   		@QueryParam("propertyValue") String propertyValue) throws Exception 
	{
		int user_id = Integer.parseInt(userID);
		String releaseYearFilter = null;
		AdaptiveSelectionController asController = new AdaptiveSelectionController();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));

		if (propertyType.equals("releaseYear")) {
			releaseYearFilter = asController.changeReleaseYearStringToReleaseYearValue(URLDecoder.decode(propertyValue, "UTF-8"));				
		}			
		
		if (releaseYearFilter != null && !releaseYearFilter.isEmpty()) {
			asController.putReleaseYearFilterByUser(user_id, propertyType, releaseYearFilter);
			asController.putLastChange(user_id, "property_rating");
		}
		else {
			System.err.println("Error - putReleaseYearFilter userID: " + user_id + " - propertyValue:" + propertyValue + " - releaseYearFilter:" + releaseYearFilter);
		}
			
		Gson gson = new Gson();
		String json = gson.toJson("null");
		json = gson.toJson(releaseYearFilter);			

		System.out.print("/putReleaseYearFilter?userID=" + userID + "&propertyType=" + propertyType + "&propertyValue=" + propertyValue + "/");

		System.out.println(json);
		
		return json;		
	}	
}







