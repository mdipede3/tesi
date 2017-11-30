package restService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//http://localhost:8080/movierecsysrestful/restService/sayHello

@Path("/sayHello")
public class SayHello {

  // This method is called if TEXT_PLAIN is request
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String sayTextHello() {
    return "Ciao Francesco - Text Hello";
  }

  // This method is called if XML is request
  @GET
  @Produces(MediaType.TEXT_XML)
  public String sayXMLHello() {
    return "<?xml version=\"1.0\"?>" + "<hello>Ciao Francesco - XML Hello" + "</hello>";
  }

  // This method is called if HTML is request
  @GET
  @Produces(MediaType.TEXT_HTML)
  public String sayHtmlHello() {
    return "<html> " + "<title>" + "Say HTML Hello" + "</title>"
        + "<body><h3>" + "Ciao Francesco - HTML Hello" + "</body></h3>" + "</html> ";
  }

} 
