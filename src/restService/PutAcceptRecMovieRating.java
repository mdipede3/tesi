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


//http://localhost:8080/movierecsysrestful/restService/recMovieRating/putAcceptRecMovieRating?userID=6&movieURI=http://dbpedia.org/resource/Good_Will_Hunting&rating=1
//http://localhost:8080/movierecsysrestful/restService/recMovieRating/putAcceptRecMovieRating?userID=6&movieURI=http://dbpedia.org/resource/Good_Will_Hunting&rating=3
@Path("/recMovieRating")
public class PutAcceptRecMovieRating {
	
	//Tomcat non permette la put, ci sara' un modo per configurarlo attraverso web.xml
	//ma per il momento la camuffiamo in get
	@Context ServletContext servletContext;
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("/putAcceptRecMovieRating")
	public String putAcceptRecMovieRating(  @QueryParam("userID") String userID,
							   	 			@QueryParam("movieURI") String movieURI,
							   	 			@QueryParam("rating") String rating) throws Exception 
	{
		int user_id = Integer.parseInt(userID);
		Integer r = Integer.parseInt(rating);
		AdaptiveSelectionController asController = new AdaptiveSelectionController();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));
		
		//movieURI = asController.getResourceUriFromDbpediaMoviesSelection(movieURI);	//Controllo l'esistenza del film tra con i trailer
		movieURI = asController.getMovieUriFromMovies(movieURI); //Controllo l'esistenza del film tra tutti i film
		int numberRatedMovies;
		
		if (!movieURI.equalsIgnoreCase("null")) {
			System.out.println("/putAcceptRecMovieRating/Run...insertMovieRatedByUser userID: " + user_id + " movieURI:" + movieURI);
			asController.insertAcceptRecMovieRatedByUser(user_id, movieURI, r);
			//Per non far partire il page rank in caso di refine
			if (r.equals(1) || r.equals(2) ) {
				asController.putLastChange(user_id, "movie_rating");
			}
			
		}
		else {
			System.err.println("/putAcceptRecMovieRating/Error - insertMovieRatedByUser userID: " + user_id + " movieURI:" + movieURI);
		}		
		numberRatedMovies = asController.getNumberRatedMovies(user_id);		
		Gson gson = new Gson();
		String json = gson.toJson(numberRatedMovies);
			
		System.out.print("/putAcceptRecMovieRating/");
		System.out.println(json);
		
		return json;		
	}	
}






