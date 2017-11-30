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


@Path("/movieToRatingByDiversity")
public class GetMovieToRatingByDiversity {
	
	@Context ServletContext servletContext;
	@GET
	@Produces({MediaType.APPLICATION_JSON, "text/json"})
	@Path("/getMovieToRatingByDiversity")
	public String getMovieToRatingByDiversity (@QueryParam("userID") String userID) throws Exception 
	{
		String movieURI = "null";
		int user_id = Integer.parseInt(userID);		
		AdaptiveSelectionController asController = new AdaptiveSelectionController();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));
		
		movieURI = asController.getMovieToRatingByPopularMoviesOrJaccard(user_id);
		
		Gson gson = new Gson();
		String json = gson.toJson("null");
		if (movieURI != null && !movieURI.isEmpty()) {			
			json = gson.toJson(movieURI);
		}
		 		
  		System.out.print("/getMovieToRatingByDiversity/");
  		System.out.println(json);
	 
  		return json;
	}	

}
