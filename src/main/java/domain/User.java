package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Niek on 02/04/14.
 * © Aidas 2014
 */

@XmlRootElement
@Entity
public class User
{
    @Id
    @GeneratedValue
    private int ID;

    @Column(unique = true)
    private String username;
    private String firstname;
    private String lastname;


    public User()
    {
    }

    public User(String username, String firstname, String lastname)
    {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public int getID()
    {
        return ID;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

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

    public void setLastname(String lastName)
    {
        this.lastname = lastName;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (this.username != null ? this.username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        if (!(object instanceof User))
        {
            return false;
        }

        User user = (User) object;
        if (this.username == user.getUsername())
        {
            return true;
        } else
        {
            return false;
        }
    }
}
