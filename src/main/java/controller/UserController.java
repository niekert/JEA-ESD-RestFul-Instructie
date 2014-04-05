package controller;

import domain.User;
import dto.UserDTO;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import javax.ws.rs.client.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Niek on 05/04/14.
 * © Aidas 2014
 */
@Named
@SessionScoped
public class UserController implements Serializable
{
    private static final String BASEURL = "http://localhost:8080/hello/webapi/userAPI/";

    private String username;
    private String firstname;
    private String lastname;

    private User editedUser = null;

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getFirstname()
    {
        return firstname;
    }

    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }

    public String getLastname()
    {
        return lastname;
    }

    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }

    public User getEditedUser()
    {
        return editedUser;
    }

    public void setEditedUser(User editedUser)
    {
        this.editedUser = editedUser;
    }

    public void register(){
        System.out.println("Register");
        Client client = ClientBuilder.newClient();

        WebTarget target = client.target(BASEURL);

        Invocation invocation = target.request().buildPost(Entity.entity(new UserDTO(this.getUsername(), this.getFirstname(), this.getLastname()), MediaType.APPLICATION_JSON_TYPE));

        Response response = invocation.invoke();
    }

    public List<User> getUsers() {
        Client client = ClientBuilder.newClient();

        WebTarget target = client.target(BASEURL);

        Invocation invocation = target.request(MediaType.APPLICATION_JSON_TYPE).buildGet();

        Response response = invocation.invoke();



        List<User> foundUsers =  response.readEntity(new GenericType<List<User>>(){});

        return foundUsers;
    }

    public void editUser(User user){
        Client client = ClientBuilder.newClient();

        WebTarget target = client.target(BASEURL + "search/" + user.getUsername());

        Invocation invocation = target.request(MediaType.APPLICATION_JSON_TYPE).buildGet();

        Response response = invocation.invoke();

        User foundUser = response.readEntity(User.class);
        this.editedUser = foundUser;
    }

    public void saveUserChanges(){
        System.out.println("saving changes");
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(BASEURL + "/" + this.editedUser.getID());
        Invocation invocation = target.request().buildPut(Entity.entity(this.editedUser, MediaType.APPLICATION_JSON_TYPE));

        invocation.invoke();

        this.editedUser = null;
    }

    public void alert(){
        System.out.println("alert");
    }
}
