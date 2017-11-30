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

//http://localhost:8080/movierecsysrestful/restService/numbers/getNumberRatedMovies?userID=6
//http://localhost:8080/movierecsysrestful/restService/numbers/getNumberRatedProperties?userID=6
//http://localhost:8080/movierecsysrestful/restService/numbers/getNumberPagerankCicle?userID=6
//http://localhost:8080/movierecsysrestful/restService/numbers/putNumberPagerankCicle?userID=6&pagerankCicle=2
@Path("/numbers")
public class GetNumberService {
	
	@Context ServletContext servletContext;
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("/getNumberPagerankCicle")
	public String getNumberPagerankCicle (@QueryParam("userID") String userID) throws Exception 
	{
		int user_id = Integer.parseInt(userID);
		AdaptiveSelectionController asController = new AdaptiveSelectionController();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));
		
		int numberPagerankCicle = asController.getNumberPagerankCicle(user_id);
	
		Gson gson = new Gson();
		String json = gson.toJson(numberPagerankCicle);
		 
		System.out.print("/numbers/getNumberPagerankCicle/");
		System.out.println(json);
		
		return json;		
	}
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("/putNumberPagerankCicle")
	public String putNumberPagerankCicle (@QueryParam("userID") String userID,
										 @QueryParam("pagerankCicle") String pagerankCicle) throws Exception 
	{
		int user_id = Integer.parseInt(userID);
		int pagerank_cicle = Integer.parseInt(pagerankCicle);
		
		AdaptiveSelectionController asController = new AdaptiveSelectionController();	
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));
		
		asController.putNumberPagerankCicleByUser(user_id, pagerank_cicle);
		int numberPagerankCicle = asController.getNumberPagerankCicle(user_id);
		
		Gson gson = new Gson();
		String json = gson.toJson(numberPagerankCicle);
		
		System.out.print("/numbers/putNumberPagerankCicle/");
		System.out.println(json);
		
		return json;
		
	}
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("/getNumberRatedMovies")
	public String getNumberRatedMovies (@QueryParam("userID") String userID) throws Exception 
	{
		int user_id = Integer.parseInt(userID);
		AdaptiveSelectionController asController = new AdaptiveSelectionController();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));
		
		int numberRatedMovies = asController.getNumberRatedMovies(user_id);
	
		Gson gson = new Gson();
		String json = gson.toJson(numberRatedMovies);
		 
		System.out.print("/numbers/getNumberRatedMovies/");
		System.out.println(json);
		
		return json;		
	}
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("/getNumberRatedProperties")
	public String getNumberRatedProperties (@QueryParam("userID") String userID) throws Exception 
	{
		int user_id = Integer.parseInt(userID);
		AdaptiveSelectionController asController = new AdaptiveSelectionController();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));
		
		int numberRatedProperties = asController.getNumberRatedProperties(user_id);
		
		Gson gson = new Gson();
		String json = gson.toJson(numberRatedProperties);
		 
		System.out.print("/numbers/getNumberRatedProperties/");
		System.out.println(json);
		
		return json;		
	}
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("/getNumberRatedRecMovieList")
	public String getNumberRatedRecMovieList (@QueryParam("userID") String userID) throws Exception 
	{
		int user_id = Integer.parseInt(userID);
		AdaptiveSelectionController asController = new AdaptiveSelectionController();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));
		
		int numberRatedRecMovie = asController.getNumberRatedRecMovieByUserAndRecList(user_id);
	
		Gson gson = new Gson();
		String json = gson.toJson(numberRatedRecMovie);
		 
		System.out.print("/numbers/getNumberRatedRecMovieList/");
		System.out.println(json);
		
		return json;		
	}
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("/getNumberRefineFromRecMovieList")
	public String getNumberRefineFromRecMovieList (@QueryParam("userID") String userID) throws Exception 
	{
		int user_id = Integer.parseInt(userID);
		AdaptiveSelectionController asController = new AdaptiveSelectionController();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));
		
		int numberRatedRecMovie = asController.getNumberRefineFromRecMovieListByUserAndRecList(user_id);
	
		Gson gson = new Gson();
		String json = gson.toJson(numberRatedRecMovie);
		 
		System.out.print("/numbers/getNumberRefineFromRecMovieList/");
		System.out.println(json);
		
		return json;		
	}
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("/getNumberRecommendationList")
	public String getNumberRecommendationList (@QueryParam("userID") String userID) throws Exception 
	{
		int user_id = Integer.parseInt(userID);
		AdaptiveSelectionController asController = new AdaptiveSelectionController();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));
		
		int numberRecommendationList = asController.getNumberRecommendationList(user_id);
	
		Gson gson = new Gson();
		String json = gson.toJson(numberRecommendationList);
		 
		System.out.print("/numbers/getNumberRecommendationList/");
		System.out.println(json);
		
		return json;		
	}
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("/putNumberRecommendationList")
	public String putNumberRecommendationList (@QueryParam("userID") String userID,
										 @QueryParam("numberRecommendationList") String numberRecommendationList) throws Exception 
	{
		int user_id = Integer.parseInt(userID);
		int number_recommendation_list = Integer.parseInt(numberRecommendationList);
		
		AdaptiveSelectionController asController = new AdaptiveSelectionController();	
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));
		
		asController.putNumberRecommendationListByUser(user_id, number_recommendation_list);
		int new_number_recommendation_list = asController.getNumberRecommendationList(user_id);
		
		Gson gson = new Gson();
		String json = gson.toJson(new_number_recommendation_list);

		System.out.print("/numbers/putNumberRecommendationList/");
		System.out.println(json);
		
		return json;
		
	}
	
}
