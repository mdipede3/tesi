package restService;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
 
//http://localhost:8080/movierecsysrestful/restService/actualPath
//http://localhost:8080/movierecsysrestful/restService/actualPath?path=WebContent
@Path("/actualPath")
public class GetActualPath {

	@Context ServletContext servletContext;
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getActualPath(@QueryParam("path") String requestedPath) {
        String path = requestedPath == null ? "/WEB-INF" : requestedPath;
        String actualPath = servletContext.getRealPath("/WEB-INF");
        //String actualPath = servletContext.getRealPath("/WebContent");
        return String.format("Ciao Francesco! \nEcco l'intero path della rotta %s\nPath: %s", path, actualPath);
    }



}  