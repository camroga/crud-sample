package rest;

import exception.DataNotFoundException;
import exception.ServiceException;
import service.Customer;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("customer")
public class CustomerWs implements CustomerWsApi {
  
    private static final Logger LOGGER = Logger.getLogger(CustomerWs.class.getName());
  
    @Inject
    Customer customer;
  
    @GET
    @Path("get")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response getCustomers() {
        LOGGER.log(Level.INFO, "Invoked method getCustomers");
        return execute(customer);
    }
  
    Response execute(final Customer customerService) {
        Response response;
        String responseData;
        String messageError = "";
        try {
            responseData = customerService.getData();
            response = Response.ok(responseData).build();
        } catch (DataNotFoundException ex) {
            messageError = ex.getMessage();
            response = Response.status(Response.Status.NOT_FOUND).entity(this.messageToJson(ex.getMessage())).build();
        } catch (ServiceException ex) {
            messageError = ex.getMessage();
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).
                    entity(this.messageToJson(Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase())).build();
        } finally {
            if (!messageError.isEmpty()) {
                LOGGER.log(Level.INFO, "Class Source Error: [{0}], MessageError :[{1}]",
                        new String[]{customerService.getClass().getSimpleName(), messageError});
            }
        }

        return response;
    }
  
    private String messageToJson(String messageDescription) {
        return "{\"message\":\" " + messageDescription + "\"}";
    }
}
