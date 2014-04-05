package exception;

/**
 * Created by Niek on 05/04/14.
 * © Aidas 2014
 */
public class FailedToInsertException extends Exception
{
    public FailedToInsertException(String error){
        super(error);
    }
}
