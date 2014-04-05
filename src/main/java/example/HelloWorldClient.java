package example;

import soapapi.PostAPIService;
import soapapi.TimeLine;
import soapapi.TweetDTO;

/**
 * Created by Niek on 05/04/14.
 * � Aidas 2014
 */
public class HelloWorldClient {
  public static void main(String[] argv) {
      soapapi.PostAPI service = new PostAPIService().getPostAPIPort();
      //invoke business method
      TimeLine timeline = service.getUsertimeline("Niek");

      for (TweetDTO tweetDTO :timeline.getTweets())
      {
          System.out.println(tweetDTO.getContent());
      }

  }
}
