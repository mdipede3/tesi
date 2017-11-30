package restService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import graph.AdaptiveSelectionController;

import javax.servlet.ServletContext;
//import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
//import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

//http://localhost:8080/movierecsysrestful/restService/userDetailsMovieRequest/putDetailsMovieRequest?userID=6&movieURI=http://dbpedia.org/resource/Forrest_Gump&numberRecommendationList=0&details=details


/**
 * 
 * @author Francesco Baccaro
 *
 */
@Path("/userDetailsMovieRequest")
public class PutDetailsMovieRequest {
	
	//Tomcat non permette la put, ci sara' un modo per configurarlo attraverso web.xml
	//ma per il momento la camuffiamo in get
	@Context ServletContext servletContext;
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("/putDetailsMovieRequest")
	public String putDetailsMovieRequest(@QueryParam("userID") String userID,
								   	 @QueryParam("movieURI") String movieURI,
								   	 @QueryParam("numberRecommendationList") String numberRecommendationList,
								   	 @QueryParam("details") String details
								   	 ) throws Exception 
	{
		int user_id = Integer.parseInt(userID);
		int number_recommendation_list = Integer.parseInt(numberRecommendationList);
		AdaptiveSelectionController asController = new AdaptiveSelectionController();

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));
		
		movieURI = asController.getMovieUriFromMovies(movieURI); //Controllo l'esistenza del film tra tutti i film
		int numberRatedMovies;
		
		if (!movieURI.equalsIgnoreCase("null")) {
			asController.insertDetailsMovieRequestByUser(user_id, movieURI, number_recommendation_list, details);
			asController.putLastChange(user_id, "pagerank");
		}
		else {
			System.err.println("/putDetailsMovieRequest/Error - insertDetailsMovieRequestByUser userID: " + user_id + " movieURI:" + movieURI);
		}		
		numberRatedMovies = asController.getNumberRatedMovies(user_id);		
		Gson gson = new Gson();
		String json = gson.toJson(numberRatedMovies);
			
		System.out.print("/putDetailsMovieRequest/userID: " + user_id + " movieURI:" + movieURI + " numberRecommendationList:" + numberRecommendationList + "/");
		System.out.println(json);
		
		return json;		
	}	
}







