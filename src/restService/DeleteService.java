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

//http://localhost:8080/movierecsysrestful/restService/delete/deleteAllMovieRated?userID=1
//http://localhost:8080/movierecsysrestful/restService/delete/deleteAllPropertyRated?userID=1
//http://localhost:8080/movierecsysrestful/restService/delete/deleteAllChatMessage?userID=1
//http://localhost:8080/movierecsysrestful/restService/delete/deleteAllUserDetail?userID=6
//http://localhost:8080/movierecsysrestful/restService/delete/deleteAllProfile?userID=1

@Path("/delete")
public class DeleteService {
	@Context ServletContext servletContext;
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("/deleteAllPropertyRated")
	public String deleteAllPropertyRated(@QueryParam("userID") String userID) throws Exception 
	{
		int user_id = Integer.parseInt(userID);
		AdaptiveSelectionController asController = new AdaptiveSelectionController();
		int oldNumberRatedProperties = asController.getNumberRatedProperties(user_id);
		
		asController.deleteAllPropertyRatedByUser(user_id);
		int numberRatedProperties = asController.getNumberRatedProperties(user_id);
		
		Gson gson = new Gson();
		String json = gson.toJson("null");
		if (numberRatedProperties < oldNumberRatedProperties ) {			
			json = gson.toJson(numberRatedProperties);
		}
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));
		
		System.out.println("oldNumberRatedProperties: " + oldNumberRatedProperties);
		System.out.println("numberRatedProperties: " + numberRatedProperties);
		System.out.print("/delete/deleteAllPropertyRated/");
		System.out.println(json);
		
		return json;
		
	}
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("/deleteAllMovieRated")
	public String deleteAllMovieRated(@QueryParam("userID") String userID) throws Exception 
	{
		int user_id = Integer.parseInt(userID);
		AdaptiveSelectionController asController = new AdaptiveSelectionController();
		int oldNumberRatedMovies = asController.getNumberRatedMovies(user_id);

		asController.deleteAllMovieRatedByUser(user_id);
		int numberRatedMovies = asController.getNumberRatedMovies(user_id);
		
		Gson gson = new Gson();
		String json = gson.toJson("null");
		if (numberRatedMovies < oldNumberRatedMovies ) {			
			json = gson.toJson(numberRatedMovies);
		}
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));
		
		System.out.println("oldNumberRatedMovies: " + oldNumberRatedMovies);
		System.out.println("numberRatedMovies: " + numberRatedMovies);
		System.out.print("/delete/deleteAllMovieRated/");
		System.out.println(json);
		
		return json;		
	}
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("/deleteAllChatMessage")
	public String deleteAllChatMessage(@QueryParam("userID") String userID) throws Exception 
	{
		int user_id = Integer.parseInt(userID);
		AdaptiveSelectionController asController = new AdaptiveSelectionController();
		int oldNumberPagerankCicle = asController.getNumberPagerankCicle(user_id);

		asController.deleteAllChatMessageByUser(user_id);
		int numberPagerankCicle = asController.getNumberPagerankCicle(user_id);
		
		Gson gson = new Gson();
		String json = gson.toJson("null");
		if (numberPagerankCicle < oldNumberPagerankCicle ) {			
			json = gson.toJson(numberPagerankCicle);
		}
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));
		
		System.out.println("oldNumberPagerankCicle: " + oldNumberPagerankCicle);
		System.out.println("numberPagerankCicle: " + numberPagerankCicle);
		System.out.print("/delete/deleteAllChatMessage/");
		System.out.println(json);
		
		return json;		
	}
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("/deleteAllRecMovies")
	public String deleteAllRecMovies(@QueryParam("userID") String userID) throws Exception 
	{
		int user_id = Integer.parseInt(userID);
		AdaptiveSelectionController asController = new AdaptiveSelectionController();
		
		asController.deleteAllRecMoviesByUser(user_id);		
		
		Gson gson = new Gson();
		String json = gson.toJson("deleteAllRecMovies");
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));
		
		System.out.print("/delete/deleteAllRecMovies/userID="+ userID + "/");
		System.out.println(json);
		
		return json;		
	}
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("/deleteAllProfile")
	public String deleteAllProfile(@QueryParam("userID") String userID) throws Exception 
	{
		int user_id = Integer.parseInt(userID);
		AdaptiveSelectionController asController = new AdaptiveSelectionController();
		int oldNumberPagerankCicle = asController.getNumberPagerankCicle(user_id);

		asController.deleteAllProfileByUser(user_id);
		int numberPagerankCicle = asController.getNumberPagerankCicle(user_id);
		
		Gson gson = new Gson();
		String json = gson.toJson("null");
		if (numberPagerankCicle < oldNumberPagerankCicle ) {			
			json = gson.toJson(numberPagerankCicle);
		}
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));
		
		System.out.println("oldNumberPagerankCicle: " + oldNumberPagerankCicle);
		System.out.println("numberPagerankCicle: " + numberPagerankCicle);
		System.out.print("/delete/deleteAllProfile/");
		System.out.println(json);
		
		return json;		
	}
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("/deleteAllUserDetail")
	public String deleteAllUserDetail(@QueryParam("userID") String userID) throws Exception 
	{
		int user_id = Integer.parseInt(userID);
		AdaptiveSelectionController asController = new AdaptiveSelectionController();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));
		int oldNumberPagerankCicle = asController.getNumberPagerankCicle(user_id);

		asController.deleteAllUserDetail(user_id);
		int numberPagerankCicle = asController.getNumberPagerankCicle(user_id);
		
		Gson gson = new Gson();
		String json = gson.toJson("null");
		if (numberPagerankCicle < oldNumberPagerankCicle ) {			
			json = gson.toJson(numberPagerankCicle);
		}

		System.out.print("/deleteAllUserDetail/");
		System.out.println(json);
		
		return json;		
	}
	
	
	
}






