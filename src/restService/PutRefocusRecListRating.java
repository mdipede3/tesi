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
 * Inserisce il film raccomandato nella tabella
 * @author Francesco
 *
 */

@Path("/userRefocusRecListRating")
public class PutRefocusRecListRating {
	
	//Tomcat non permette la put, ci sara' un modo per configurarlo attraverso web.xml
	//ma per il momento la camuffiamo in get
	@Context ServletContext servletContext;
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("/putRefocusRecListRating")
	public String putRefocusRecListRating(@QueryParam("userID") String userID) throws Exception 
	{
		int user_id = Integer.parseInt(userID);

		AdaptiveSelectionController asController = new AdaptiveSelectionController();

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));
		
		//se il numero di film raccomandati valutati è zero puoi avviare il refocus
		asController.setRefocusRecListByUser(user_id);
		asController.putLastChange(user_id, "movie_rating");
		int numberRatedMovies = asController.getNumberRatedMovies(user_id);
		
		Gson gson = new Gson();
		String json = gson.toJson(numberRatedMovies);
		
		System.out.print("/putMovieRating/");
		System.out.println(json);
		
		return json;		
	}	
}







