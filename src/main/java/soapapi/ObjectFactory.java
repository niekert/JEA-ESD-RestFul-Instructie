
package soapapi;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the soapapi package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Timeline_QNAME = new QName("http://webapi.kwetter/", "timeline");
    private final static QName _TweetDTO_QNAME = new QName("http://webapi.kwetter/", "tweetDTO");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: soapapi
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TimeLine }
     * 
     */
    public TimeLine createTimeLine() {
        return new TimeLine();
    }

    /**
     * Create an instance of {@link TweetDTO }
     * 
     */
    public TweetDTO createTweetDTO() {
        return new TweetDTO();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TimeLine }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webapi.kwetter/", name = "timeline")
    public JAXBElement<TimeLine> createTimeline(TimeLine value) {
        return new JAXBElement<TimeLine>(_Timeline_QNAME, TimeLine.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TweetDTO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webapi.kwetter/", name = "tweetDTO")
    public JAXBElement<TweetDTO> createTweetDTO(TweetDTO value) {
        return new JAXBElement<TweetDTO>(_TweetDTO_QNAME, TweetDTO.class, null, value);
    }

}
