package restService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
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
 * Tra i film raccomandabili per l'utente (userID)
 * Seleziona i nodi film che hanno uno specifico valore come nodo proprieta', es. Steven spilberg
 * e l'arco di un certo tipo, es. regista 
 */


//http://localhost:8080/movierecsysrestful/restService/films?userID=6&propertyName=James_Cameron&propertyType=director
//http://localhost:8080/movierecsysrestful/restService/films?userID=8&propertyName=steven_spielberg&propertyType=director

//http://localhost:8080/movierecsysrestful/restService/movieList/getMovieListFromProperty?userID=6&propertyName=David_Fincher&propertyType=director

//probabilmente in disuso, è stata usata nella versiona alpha del bot
@Path("/movieList")
public class GetMovieListFromPropertyType {	
	  
	@Context ServletContext servletContext;
	@GET
	@Produces({MediaType.APPLICATION_JSON, "text/json"})
	@Path("/getMovieListFromProperty")
	public String getMovieListFromPropertyType(@QueryParam("userID") String userID,
							@QueryParam("propertyName") String propertyValue,
							@QueryParam("propertyType") String propertyType) throws Exception 
	{
		int user_id = Integer.parseInt(userID);

		//String actualPath = servletContext.getRealPath("/WEB-INF");
		AdaptiveSelectionController asController = new AdaptiveSelectionController();
		
		String propertyURI = null;
		//System.out.println("propertyType: " + propertyType);
		 if (propertyType.equals("genre") || propertyType.equals("releaseYear") || propertyType.equals("runtimeRange")) {
			 propertyURI = propertyValue;
		 }
		 else {
			 propertyURI = "http://dbpedia.org/resource/"+propertyValue;
		}	
		//chat.setItemListFromProperty(user_id, propertyType, propertyURI);
		Map<String, List<String>> movieMap = new HashMap<String, List<String>>();
		movieMap = asController.getItemListFromProperty(user_id, propertyType, propertyURI);
		
		//evito il loop
/*		if (movieMap.isEmpty() == true) {
			System.out.println("Run PageRank...Just a moment ...user_id: " + user_id);
			asController.createGraphAndRunPageRank(user_id);
			//chat.setItemListFromProperty(user_id, propertyType, propertyURI);
			movieMap = new HashMap<String, List<String>>();
			movieMap = asController.getItemListFromProperty(user_id, propertyType, propertyURI);
		}
*/
		Gson gson = new Gson();
		String json = gson.toJson("null");
		
		if ((movieMap != null && !movieMap.isEmpty()) && (!movieMap.get(propertyURI).isEmpty())) {			
			json = gson.toJson(movieMap);
		}
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));
		
		System.out.print("/movieList/getMovieListFromProperty/");
		if (json.equals("null")) {
			System.out.println(json);
		}
		else {
			System.out.println("ok");
		}
		
		return json;		
	}

}
