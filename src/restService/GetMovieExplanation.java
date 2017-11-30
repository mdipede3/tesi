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


//http://localhost:8080/movierecsysrestful/restService/getMovieExplanation?userID=6&movieName=Titanic_(1997_film)
@Path("/")
public class GetMovieExplanation {
	
	@Context ServletContext servletContext;
	@GET
	@Produces({MediaType.APPLICATION_JSON, "text/json"})
	@Path("/getMovieExplanation")
	public String getMovieExplanation (	@QueryParam("userID") String userID,
												@QueryParam("movieName") String movieName) throws Exception 
	{
		int user_id = Integer.parseInt(userID);
		String movieURI = "http://dbpedia.org/resource/"+movieName;
		AdaptiveSelectionController asController = new AdaptiveSelectionController();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));
		
		
		String explanationMovie = asController.getMovieExplanationByUserMovie(user_id, movieURI);
        String explanationLikeProperty = asController.getMovieExplanationByLikeUserProperty(user_id, movieURI);
        String explanationDislikeProperty = asController.getMovieExplanationByDislikeUserProperty(user_id, movieURI);
        //String explanationExpLODTopOne = asController.getExplanationFromExpLODTopOne(user_id, movieURI);
        
        String explanationString = null;

//        if (explanationExpLODTopOne != null && !explanationExpLODTopOne.isEmpty() && !explanationExpLODTopOne.contentEquals("")) {
//			if (explanationLikeProperty != null && !explanationLikeProperty.isEmpty()) {
//				explanationString = explanationExpLODTopOne + " And " + explanationLikeProperty;
//			}
//			else {
//				explanationString = explanationExpLODTopOne;
//			}
//		}
//	else if (explanationMovie != null && !explanationMovie.isEmpty()) {        
        if (explanationMovie != null && !explanationMovie.isEmpty()) {
			if (explanationLikeProperty != null && !explanationLikeProperty.isEmpty()) {
				explanationString = explanationMovie + ".\nAnd " + explanationLikeProperty;
			}
			else {
				explanationString = explanationMovie;
			}
		}
		else if (explanationLikeProperty != null && !explanationLikeProperty.isEmpty()) {			
			explanationString = explanationLikeProperty;
		}
		else {
			explanationString = explanationDislikeProperty;			
		}
		
		Gson gson = new Gson();
		String json = gson.toJson("Sorry, this recommendation is serendipitous also for me 🙂.\nI’m not able to provide an explanation 🤔");
		
		if (explanationString != null && !explanationString.isEmpty()) {			
	  		json = gson.toJson(explanationString + ".");
		}
		
  		System.out.print("/getMovieExplanation/");
  		System.out.println(json);
  		
  		return json;
	}

}