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

//http://localhost:8080/movierecsysrestful/restService/chatMessages/getChatMessage?userID=129877748&replyFunctionCall=/start&pagerankCicle=2
@Path("/chatMessages")
public class GetChatMessage {
	
	@Context ServletContext servletContext;
	@GET
	@Produces({MediaType.APPLICATION_JSON, "text/json"})
	@Path("/getChatMessage")
	public String getChatMessage (	@QueryParam("userID") String userID,
									@QueryParam("context") String context,
									@QueryParam("pagerankCicle") String pagerankCicle) throws Exception 
	{

		int user_id = Integer.parseInt(userID);	
		int pagerank_cicle = Integer.parseInt(pagerankCicle);
		Map<String,String> messageDetailMap = new HashMap<String, String>();
		AdaptiveSelectionController asController = new AdaptiveSelectionController();

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));

		messageDetailMap = asController.getChatMessageByUser(user_id, context, pagerank_cicle);
		
		Gson gson = new Gson();
		String json = gson.toJson("null");
		//messageDetailMap != null && !messageDetailMap.isEmpty()
		if (messageDetailMap != null && !messageDetailMap.isEmpty()) {			
	  		json = gson.toJson(messageDetailMap);
		}
		
		
		 		
  		System.out.print("/getChatMessage/userID=" + user_id + "&context=" + context + "&pagerankCicle=" + pagerank_cicle + "/");
  		System.out.println(json);
	 
  		return json;
	}
	
}
