package controller;

import soapapi.PostAPIService;
import soapapi.TimeLine;
import soapapi.TweetDTO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

/**
 * Created by Niek on 05/04/14.
 * © Aidas 2014
 */
@Named
@RequestScoped
public class SoapController
{
    private String username;
    private String tweetContents;

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getTweetContents()
    {
        return tweetContents;
    }

    public void setTweetContents(String tweetContents)
    {
        this.tweetContents = tweetContents;
    }

    public List<TweetDTO> getTimeline(){
        soapapi.PostAPI service = new PostAPIService().getPostAPIPort();


        if(username != null)
        {
            System.out.println("Username: " + username);
            TimeLine timeLine = service.getUsertimeline(username);
            return timeLine.getTweets();
        }

        return null;
    }

    public void loadTimeline(){
        this.getTimeline();
    }

    public void postTweet(){
        if(this.username != null && this.tweetContents != null){
            soapapi.PostAPI service = new PostAPIService().getPostAPIPort();
            service.postNewTweet(username, tweetContents);
        }
    }
}
