package dto;

import domain.User;

/**
 * Created by Niek on 05/04/14.
 * © Aidas 2014
 */
public class UserDTO
{
    private String username;
    private String firstname;
    private String lastname;


    //region Properties
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
    //endregion

    public UserDTO(){};

    public UserDTO(String username, String firstname, String lastname){
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public UserDTO(User user){
        this.username = user.getUsername();
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
    }


}
