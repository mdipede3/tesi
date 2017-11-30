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

//http://localhost:8080/movierecsysrestful/restService/moviesToRating/getMoviesToRatingFromJaccardDistanceMap?userID=6
//http://localhost:8080/movierecsysrestful/restService/movieToRating/getMovieToRating?userID=6
@Path("/moviesToRating")
public class GetMoviesToRatingFromJaccardDistanceMap {
	//TODO Questa ci servir� per modificare le property che l'utente ha indicato nelle preferenze, � tutto da fare
	
	
	
	@Context ServletContext servletContext;
	@GET
	@Produces({MediaType.APPLICATION_JSON, "text/json"})
	@Path("/getMoviesToRatingFromJaccardDistanceMap")
	public String getMoviesToRatingFromJaccardDistanceMap (@QueryParam("userID") String userID) throws Exception 
	{
		int user_id = Integer.parseInt(userID);
		Map<String, Double> moviesJaccardDistanceMap = new HashMap<String, Double>();
		AdaptiveSelectionController asController = new AdaptiveSelectionController();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));
		
		moviesJaccardDistanceMap = asController.getMoviesToRatingFromJaccardDistanceMapByUser(user_id);
		
		Gson gson = new Gson();
		String json = gson.toJson("null");
		
		if (moviesJaccardDistanceMap != null && !moviesJaccardDistanceMap.isEmpty()) {			
	  		json = gson.toJson(moviesJaccardDistanceMap);
		}
		
  		System.out.print("/moviesToRating/getMoviesToRatingFromJaccardDistanceMap/");
  		System.out.println(json);
  		
  		return json;
  		
	}

}

