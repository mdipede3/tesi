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

@Path("/chatMessage")
public class PutChatMessage {

	@Context ServletContext servletContext;
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("/putChatMessage")
	public String putChatMessage(@QueryParam("userID") String userID,
							   	 @QueryParam("messageID") String messageID,
							   	 @QueryParam("context") String context,
							   	 @QueryParam("replyText") String replyText,
							   	 @QueryParam("replyFunctionCall") String replyFunctionCall,
							   	 @QueryParam("pagerankCicle") String pagerankCicle,
							   	 @QueryParam("botName") String botName,
							   	 @QueryParam("botTimestamp") String botTimestamp,
							   	 @QueryParam("responseType") String responseType) throws Exception				   	 
							 			   	 
	{
		int user_id = Integer.parseInt(userID);
		int message_id = Integer.parseInt(messageID);
		int pagerank_cicle = Integer.parseInt(pagerankCicle);
		int bot_timestamp = Integer.parseInt(botTimestamp);
		
		AdaptiveSelectionController asController = new AdaptiveSelectionController();

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));

		String returnString = asController.putChatMessageByUser(user_id, message_id, context, replyText, replyFunctionCall, pagerank_cicle, botName, bot_timestamp, responseType);
		
		Gson gson = new Gson();
		String json = gson.toJson(returnString);		
		
		System.out.print("/putChatMessage?userID=" + userID + "&context=" + context + "&replyText=" + replyText +"&replyFunctionCall=" + replyFunctionCall +  "&pagerankCicle=" + pagerankCicle +"/");

		System.out.println(json);
		
		return json;		
	}	
}







