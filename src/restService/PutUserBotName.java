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

//http://localhost:8080/movierecsysrestful/restService/userBotName/putUserBotName?userID=6&botName=conf1testrecsysbot
@Path("/botName")
public class PutUserBotName {
	
	@Context ServletContext servletContext;
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("/putUserBotName")
	public String putUserBotName(	@QueryParam("userID") String userID,
									@QueryParam("botName") String botName) throws Exception 
	{
		int user_id = Integer.parseInt(userID);
		
		AdaptiveSelectionController asController = new AdaptiveSelectionController();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));

		if (botName != null && !botName.isEmpty()) {
			asController.putBotNameByUser(user_id, botName);
		}
		else {
			System.err.println("Error - putUserBotName userID: " + user_id + " - botName:" + botName);
		}
			
		Gson gson = new Gson();
		String json = gson.toJson("null");
		json = gson.toJson(botName);			

		System.out.print("/putUserBotName?userID=" + userID + "&botName=" + botName + "/");
		System.out.println(json);
		
		return json;		
	}	
}