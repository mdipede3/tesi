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

//http://localhost:8080/movierecsysrestful/restService/explanation?movieName=Barry_Lyndon

//http://localhost:8080/movierecsysrestful/restService/movieDetail/getAllPropertyListFromMovie?movieName=Barry_Lyndon
@Path("/movieDetail")
public class GetAllPropertyListFromMovie {
	
	@Context ServletContext servletContext;
	@GET
	@Produces({MediaType.APPLICATION_JSON, "text/json"})
	@Path("/getAllPropertyListFromMovie")
	public String getAllPropertyListFromMovie (@QueryParam("movieName") String movieName) throws Exception 
	{
		String movieURI = "http://dbpedia.org/resource/"+movieName;
		AdaptiveSelectionController asController = new AdaptiveSelectionController();
		List<List<String>> propertyList = asController.getAllPropertyListFromItem(movieURI);
		Map<String, List<List<String>>> movieMap = new HashMap<String, List<List<String>>>();
		movieMap.put(movieURI, propertyList);
		
		Gson gson = new Gson();
		String json = gson.toJson("null");
		if (!movieMap.get(movieURI).isEmpty()) {			
	  		json = gson.toJson(movieMap);
		}
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));
		
  		System.out.print("/movieDetail/getAllPropertyListFromMovie/");
		if (json.equals("null")) {
			System.out.println(json);
		}
		else {
			System.out.println("ok");
		}
  		
  		return json;
	}

}
