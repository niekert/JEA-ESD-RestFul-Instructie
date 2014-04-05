package webapi;

import domain.User;
import dto.UserDTO;
import exception.FailedToInsertException;
import service.UserService;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

/**
 * Created by Niek on 02/04/14.
 * © Aidas 2014
 */
@Path("/userAPI")
public class UserAPI
{

    @Inject
    UserService service;

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public boolean registerUser(UserDTO user) throws FailedToInsertException
    {
        User toAdd = new User(user.getUsername(), user.getFirstname(), user.getLastname());
        try
        {
            service.registerUser(toAdd);
        } catch (Exception ex)
        {
            throw new FailedToInsertException("User with username " + user.getUsername() + " already exists");
        }
        return true;
    }

    @GET
    @Path("search/{username}")
    @Produces("application/json")
    public User findUser(@PathParam("username") String username)
    {
        User foundUser = service.getUser(username);
        return foundUser;
    }

    @PUT
    @Path("{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public void updateUser(User toUpdate)
    {
        service.editUser(toUpdate);
    }

    @GET
    @Produces("application/json")
    public List<User> listUsers()
    {
        List<User> users = service.getAllUsers();
        return users;
    }
}
