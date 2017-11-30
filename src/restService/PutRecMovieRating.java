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
/**
 * Inserisce il film raccomandato nella tabella e aggiorna il rating, il refine e il refocus se la chiave esiste già
 * @author Francesco
 *
 */

@Path("/ratingsRecMovie")
public class PutRecMovieRating {
	
	//Tomcat non permette la put, ci sara' un modo per configurarlo attraverso web.xml
	//ma per il momento la camuffiamo in get
	@Context ServletContext servletContext;
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("/putRecMovieRating")
	public String putRecMovieRating(@QueryParam("userID") String userID,
								   	 @QueryParam("movieURI") String movieURI,
								   	 @QueryParam("numberRecommendationList") String numberRecommendationList,
								   	 @QueryParam("rating") String rating,
								   	 @QueryParam("position") String position,
								   	 @QueryParam("pagerankCicle") String pagerankCicle,
								   	 @QueryParam("refine") String refine,
								   	 @QueryParam("refocus") String refocus,
								   	 @QueryParam("botName") String botName,
								   	 @QueryParam("messageID") String messageID,
								   	 @QueryParam("botTimestamp") String botTimestamp,
								   	 @QueryParam("recommendatinsList") String recommendatinsList,
								   	 @QueryParam("ratingsList") String ratingsList
								   	 ) throws Exception 
	{
		int user_id = Integer.parseInt(userID);
		int r = Integer.parseInt(rating);
		int pos = Integer.parseInt(position);
		int pagerank_cicle = Integer.parseInt(pagerankCicle);
		int message_id = Integer.parseInt(messageID);
		int bot_timestamp = Integer.parseInt(botTimestamp);
		int number_recommendation_list = Integer.parseInt(numberRecommendationList);
		AdaptiveSelectionController asController = new AdaptiveSelectionController();
		
		//(user_id, movieURI, messageID, r, position, pagerankCicle, refineRefocus, botName, recommendatinsList, ratingsList, numberRecommendationList);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));
		
		//movieURI = asController.getResourceUriFromDbpediaMoviesSelection(movieURI);	//Controllo l'esistenza del film tra con i trailer
		movieURI = asController.getMovieUriFromMovies(movieURI); //Controllo l'esistenza del film tra tutti i film
		int numberRatedMovies;
		
		if (!movieURI.equalsIgnoreCase("null")) {
			asController.insertRecMovieRatedByUser(user_id, movieURI,number_recommendation_list, r, pos, pagerank_cicle, refine, refocus, botName, message_id, bot_timestamp, recommendatinsList, ratingsList);
			asController.putLastChange(user_id, "movie_rating");
		}
		else {
			System.err.println("/putRecMovieRating/Error - insertRecMovieRatingByUser userID: " + user_id + " movieURI:" + movieURI);
		}		
		numberRatedMovies = asController.getNumberRatedMovies(user_id);		
		Gson gson = new Gson();
		String json = gson.toJson(numberRatedMovies);
			
		System.out.print("/putRecMovieRating/userID: " + user_id + " movieURI:" + movieURI + " numberRecommendationList:" + numberRecommendationList + " refine:" + refine + " refocus:" + refocus + "/");
		System.out.println(json);
		
		return json;		
	}	
}






