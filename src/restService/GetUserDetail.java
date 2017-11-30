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

//http://localhost:8080/movierecsysrestful/restService/users/getUserDetail?userID=6
@Path("/users")
public class GetUserDetail {
	
	@Context ServletContext servletContext;
	@GET
	@Produces({MediaType.APPLICATION_JSON, "text/json"})
	@Path("/getUserDetail")
	public String getUserDetail (@QueryParam("userID") String userID) throws Exception 
	{

		int user_id = Integer.parseInt(userID);	
		Map<String,String> userDetailMap = new HashMap<String, String>();
		AdaptiveSelectionController asController = new AdaptiveSelectionController();
		userDetailMap = asController.getUserDetail(user_id);
		
		Gson gson = new Gson();
		String json = gson.toJson("null");
		
		if (userDetailMap != null && !userDetailMap.isEmpty()) {			
	  		json = gson.toJson(userDetailMap);
		}
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));
		 		
  		System.out.print("/users/getUserDetail/userID=" + user_id);
  		System.out.println(json);
	 
  		return json;
	}
	
}