package exceptionMapper;

import exception.FailedToInsertException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by Niek on 05/04/14.
 * © Aidas 2014
 */
@Provider
public class InsertionFailedMapper implements
        ExceptionMapper<FailedToInsertException>
{
    @Override
    public Response toResponse(FailedToInsertException e)
    {
        return Response.status(500).entity(e.getMessage()).type("text/plain").build();
    }
}
