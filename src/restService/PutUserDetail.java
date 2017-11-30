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

//http://localhost:8080/movierecsysrestful/restService/user/putUserDetail?userID=6&firstname=Francesco&lastname=Baccaro&username=Frencisdrame
@Path("/detail")
public class PutUserDetail {

	@Context ServletContext servletContext;
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("/putUserDetail")
	public String putUserDetail(@QueryParam("userID") String userID,
							   	 @QueryParam("firstname") String firstname,
							   	 @QueryParam("lastname") String lastname,
							   	 @QueryParam("username") String username) throws Exception 
	{
		int user_id = Integer.parseInt(userID);
		
		AdaptiveSelectionController asController = new AdaptiveSelectionController();	
		asController.putUserDetailByUser(user_id, firstname, lastname, username);
		
		Gson gson = new Gson();
		String json = gson.toJson(userID);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));
		
		System.out.print("/user/putUserDetail/userID=");
		System.out.println(json);
		
		return json;
		
	}
}
