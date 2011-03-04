package org.sintef.org.sintef.moderates.twitter;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.kevoree.annotation.*;
import org.kevoree.framework.AbstractComponentType;
import twitter4j.AsyncTwitter;
import twitter4j.AsyncTwitterFactory;
import twitter4j.DirectMessage;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterAdapter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.TwitterListener;
import twitter4j.conf.ConfigurationBuilder;

/**
 * This Kevoree component encapsulate the Twitter account described by the 4 attributes.
 * @author Brice Morin
 * @copyright SINTEF IKT
 */
@DictionaryType({
    @DictionaryAttribute(name = "consumerKey", defaultValue = "o3xCTZjD1rXJQWVoatEVhQ", optional = false),
    @DictionaryAttribute(name = "consumerSecret", defaultValue = "LqSsYCfjE17zW45nJK2fswY3RtbqWE0s1kyYtgoSy0", optional = false),
    @DictionaryAttribute(name = "accessToken", defaultValue = "246728847-dwYevnABwrt9Y5303nDSFQ8DLF9CwsxZfYX4RvNK", optional = false),
    @DictionaryAttribute(name = "accessTokenSecret", defaultValue = "foTxnFmS5IEChoSTdJGw5nlGvxYipnS4d4ZeKN4v0", optional = false)
})
@Library(name = "Moderates::IoS")
@ComponentType
public class TwitterComponent extends AbstractComponentType {

    private Object LOCK = new Object();
    private AsyncTwitterFactory factory;
    private AsyncTwitter twitter;
    private TwitterListener twitterListener;
    private String consumerKey;
    private String consumerSecret;
    private String accessToken;
    private String accessTokenSecret;

    public TwitterComponent() {
    }

    @Start
    public void start() {



        consumerKey = (String) this.getDictionary().get("consumerKey");
        consumerSecret = (String) this.getDictionary().get("consumerSecret");
        accessToken = (String) this.getDictionary().get("accessToken");
        accessTokenSecret = (String) this.getDictionary().get("accessTokenSecret");

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true).setOAuthConsumerKey(consumerKey).setOAuthConsumerSecret(consumerSecret).setOAuthAccessToken(accessToken).setOAuthAccessTokenSecret(accessTokenSecret);

        twitterListener = new TwitterComponentAdapter(this);

        factory = new AsyncTwitterFactory(cb.build(), twitterListener);
        twitter = factory.getInstance();
    }

    @Update
    public void update() {
    }

    @Stop
    public void stop() {
    }

    public void sendTwit(String msg) {
        twitter.updateStatus(msg);
        synchronized (LOCK) {
            try {
                LOCK.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(TwitterComponent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Logger.getLogger(TwitterComponent.class.getName()).log(Level.INFO, "Status updated with: " + msg);
    }

    private void forwardTwit(DirectMessage message) {
        System.out.println();
    }

    private class TwitterComponentAdapter extends TwitterAdapter {

        private TwitterComponent twitter;

        public TwitterComponentAdapter(TwitterComponent twitter) {
            this.twitter = twitter;
        }

        @Override
        public void updatedStatus(Status statuses) {
            super.updatedStatus(statuses);
            System.out.println("TwitterComponentAdapter.updatedStatus");
            System.out.println("\t" + statuses.getText());

            synchronized(LOCK) {
                LOCK.notify();
            }
        }

        /* @Override
        public void gotDirectMessage(DirectMessage message) {
        super.gotDirectMessage(message);
        System.out.println("TwitterComponentAdapter.gotDirectMessages");
        System.out.println("\t" + message);
        }*/
        @Override
        public void gotDirectMessages(ResponseList messages) {
            super.gotDirectMessages(messages);
            System.out.println("TwitterComponentAdapter.gotDirectMessages");
            for (Object m : messages) {
                System.out.println("\t" + m);
            }
        }
    }

    public static void main(String args[]) {
        /*      Twitter twitter;
        TwitterFactory factory = new TwitterFactory();
        twitter = factory.getInstance();

        try {
        twitter.setOAuthConsumer("o3xCTZjD1rXJQWVoatEVhQ", "LqSsYCfjE17zW45nJK2fswY3RtbqWE0s1kyYtgoSy0");
        RequestToken requestToken = twitter.getOAuthRequestToken();
        AccessToken accessToken = null;

        System.out.println("Open the following URL and grant access to your account:");
        System.out.println(requestToken.getAuthorizationURL());
        System.out.println("Enter the PIN(if aviailable) or just hit enter.[PIN]");

        String pin;
        pin = JOptionPane.showInputDialog(null, "Enter PIN");

        accessToken = twitter.getOAuthAccessToken(requestToken, pin);


        System.out.println("Token: " + accessToken.getToken());
        System.out.println("TokenSecret: " + accessToken.getTokenSecret());
        } catch (TwitterException ex) {
        Logger.getLogger(TwitterComponent.class.getName()).log(Level.SEVERE, null, ex);
        }
         */

        TwitterComponent twitter = new TwitterComponent();
        twitter.getDictionary().put("consumerKey", "o3xCTZjD1rXJQWVoatEVhQ");
        twitter.getDictionary().put("consumerSecret", "LqSsYCfjE17zW45nJK2fswY3RtbqWE0s1kyYtgoSy0");
        twitter.getDictionary().put("accessToken", "246728847-dwYevnABwrt9Y5303nDSFQ8DLF9CwsxZfYX4RvNK");
        twitter.getDictionary().put("accessTokenSecret", "foTxnFmS5IEChoSTdJGw5nlGvxYipnS4d4ZeKN4v0");
        twitter.start();
        //twitter.sendTwit("goranko", "Hmmmmm... This should work now.... better than Franck's home-made devices ;-)");
        twitter.sendTwit("Hmmmmm... This should work now.... Using the asynchronous API");
    }
}
