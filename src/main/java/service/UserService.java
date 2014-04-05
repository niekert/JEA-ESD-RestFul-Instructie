package service;

import domain.User;
import exception.FailedToInsertException;
import org.apache.openjpa.persistence.ArgumentException;


import javax.ejb.Stateless;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Niek on 02/04/14.
 * © Aidas 2014
 */
@Stateless
public class UserService
{
    @PersistenceContext(unitName = "pu")
    EntityManager em;

    public boolean registerUser(User user) throws Exception
    {
            em.persist(user);
            return true;
    }

    public void editUser(User user)
    {
        em.merge(user);
    }

    public User getUser(String username)
    {
        Query query = em.createQuery("Select user from User user where user.username = :username");
        query.setParameter("username", username);

        List<User> resultList = query.getResultList();

        return resultList.isEmpty() ? null : resultList.get(0);
    }

    public User find(int ID){
        Query query = em.createQuery("Select user from User user where user.ID = :id");
        query.setParameter("id", ID);

        List<User> resultList = query.getResultList();
        return resultList.isEmpty() ? null : resultList.get(0);
    }

    public List<User> getAllUsers()
    {
        Query q = em.createQuery("Select user from User user");

        return q.getResultList();
    }
}