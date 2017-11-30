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
/**
 * Selezione i 5 film raccomandabili in base allo score
 */

//http://localhost:8080/movierecsysrestful/restService/propertyValueList/getPropertyValueListFromPropertyType?userID=6&propertyType=director
//http://localhost:8080/movierecsysrestful/restService/propertyValueList/getPropertyValueListFromPropertyType?userID=6&propertyType=movie
@Path("/recMovieList")
public class GetUserRecMovieList {

	@Context ServletContext servletContext;
	@GET
	@Produces({MediaType.APPLICATION_JSON, "text/json"})
	@Path("/getUserRecMovieList")
	public String getUserRecMovieList( @QueryParam("userID") String userID) throws Exception 
	{
		int user_id = Integer.parseInt(userID);
		Map<Double, String> recMovieListMap = new HashMap<Double, String>();
		AdaptiveSelectionController asController = new AdaptiveSelectionController();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));

		recMovieListMap = asController.getRecMovieListByUser(user_id);
		
		Gson gson = new Gson();
		String json = gson.toJson("null");
		
		if (recMovieListMap != null && !recMovieListMap.isEmpty()) {			
			json = gson.toJson(recMovieListMap);
		}
		 
		System.out.print("/getUserRecMovieList?userID=" + userID + "/");
		System.out.println(json);
			 
		return json;
	}

}