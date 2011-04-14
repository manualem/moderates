package org.sintef.org.sintef.moderates.twitter;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.kevoree.annotation.*;
import org.kevoree.framework.AbstractComponentType;
import org.kevoree.framework.MessagePort;
import twitter4j.AsyncTwitter;
import twitter4j.AsyncTwitterFactory;
import twitter4j.DirectMessage;
import twitter4j.ResponseList;
import twitter4j.SiteStreamsListener;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterAdapter;
import twitter4j.TwitterException;
import twitter4j.TwitterListener;
import twitter4j.TwitterMethod;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.User;
import twitter4j.UserList;
import twitter4j.UserStreamListener;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

/**
 * This Kevoree component encapsulate the Twitter account described by the 4 attributes.
 * @author Brice Morin
 * @copyright SINTEF IKT
 */
@Provides({
    @ProvidedPort(name = "sendTweet", type = PortType.MESSAGE)
})
@Requires({
    @RequiredPort(name = "forwardIncomingTweet", type = PortType.MESSAGE)
})
@DictionaryType({
    @DictionaryAttribute(name = "consumerKey", defaultValue = "o3xCTZjD1rXJQWVoatEVhQ", optional = false),
    @DictionaryAttribute(name = "consumerSecret", defaultValue = "LqSsYCfjE17zW45nJK2fswY3RtbqWE0s1kyYtgoSy0", optional = false),
    @DictionaryAttribute(name = "accessToken", defaultValue = "246728847-dwYevnABwrt9Y5303nDSFQ8DLF9CwsxZfYX4RvNK", optional = false),
    @DictionaryAttribute(name = "accessTokenSecret", defaultValue = "foTxnFmS5IEChoSTdJGw5nlGvxYipnS4d4ZeKN4v0", optional = false)
})
@Library(name = "Moderates::IoS")
@ComponentType
public class TwitterComponent extends AbstractComponentType {

    //private Object LOCK = new Object();
    private TwitterStreamFactory factory;
    private TwitterStream twitter;
    private StatusListener twitterListener;

    private AsyncTwitterFactory asyncFacto;
    private AsyncTwitter asyncTwitter;

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

        Configuration conf = cb.build();

        twitterListener = new TwitterComponentAdapter(this);

        factory = new TwitterStreamFactory(conf);
        asyncFacto = new AsyncTwitterFactory(conf);

        //, twitterListener);
        twitter = factory.getInstance();
        asyncTwitter = asyncFacto.getInstance();

        
        twitter.addListener(twitterListener);
    }

    @Update
    public void update() {
    }

    @Stop
    public void stop() {
    }

    @Port(name = "sendTweet", method = "sendTweet")
    public void sendTweet(Object msg) {
        asyncTwitter.updateStatus("AutoTweet: " + msg);
        /*synchronized (LOCK) {
        try {
        LOCK.wait();
        } catch (InterruptedException ex) {
        Logger.getLogger(TwitterComponent.class.getName()).log(Level.SEVERE, null, ex);
        }
        }*/
        Logger.getLogger(TwitterComponent.class.getName()).log(Level.INFO, "Status updated with: " + msg);
    }

    private void forwardTweet(Status status) {
        if (!status.getText().startsWith("AutoTweet: ")) {
            if (this.isPortBinded("forwardIncomingTweet")) {
                this.getPortByName("forwardIncomingTweet", MessagePort.class).process(status.getText());
                Logger.getLogger(TwitterComponent.class.getName()).log(Level.INFO, "Forwarding tweet: " + status.getText());
            }
        } else {
            Logger.getLogger(TwitterComponent.class.getName()).log(Level.INFO, "AutoTweet not forwarded: " + status.getText());
        }
    }

    private class TwitterComponentAdapter extends TwitterAdapter implements StatusListener, SiteStreamsListener, UserStreamListener{

        @Override
        public void updatedStatus(Status status) {
            super.updatedStatus(status);
            System.out.println("TwitterComponentAdapter.onStatus");
            System.out.println("\t" + status.getText());
            forwardTweet(status);
        }

        private TwitterComponent twitter;

        public TwitterComponentAdapter(TwitterComponent twitter) {
            this.twitter = twitter;
        }

        @Override
        public void onStatus(Status status) {
            System.out.println("TwitterComponentAdapter.onStatus");
            System.out.println("\t" + status.getText());
            forwardTweet(status);
        }

        @Override
        public void onDeletionNotice(StatusDeletionNotice sdn) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void onTrackLimitationNotice(int i) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void onScrubGeo(int i, long l) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void onException(Exception excptn) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void onStatus(int i, Status status) {
            System.out.println("TwitterComponentAdapter.onStatus");
            System.out.println("\t" + status.getText());
            forwardTweet(status);
        }

        @Override
        public void onDeletionNotice(int i, StatusDeletionNotice sdn) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void onFriendList(int i, int[] ints) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void onFavorite(int i, User user, User user1, Status status) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void onUnfavorite(int i, User user, User user1, Status status) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void onFollow(int i, User user, User user1) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void onUnfollow(int i, User user, User user1) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void onDirectMessage(int i, DirectMessage dm) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void onDeletionNotice(int i, int i1, int i2) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void onUserListMemberAddition(int i, User user, User user1, UserList ul) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void onUserListMemberDeletion(int i, User user, User user1, UserList ul) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void onUserListSubscription(int i, User user, User user1, UserList ul) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void onUserListUnsubscription(int i, User user, User user1, UserList ul) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void onUserListCreation(int i, User user, UserList ul) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void onUserListUpdate(int i, User user, UserList ul) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void onUserListDeletion(int i, User user, UserList ul) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void onUserProfileUpdate(int i, User user) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void onBlock(int i, User user, User user1) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void onUnblock(int i, User user, User user1) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void onDeletionNotice(long l, int i) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void onFriendList(int[] ints) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void onFavorite(User user, User user1, Status status) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void onUnfavorite(User user, User user1, Status status) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void onFollow(User user, User user1) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void onRetweet(User user, User user1, Status status) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void onDirectMessage(DirectMessage dm) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void onUserListMemberAddition(User user, User user1, UserList ul) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void onUserListMemberDeletion(User user, User user1, UserList ul) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void onUserListSubscription(User user, User user1, UserList ul) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void onUserListUnsubscription(User user, User user1, UserList ul) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void onUserListCreation(User user, UserList ul) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void onUserListUpdate(User user, UserList ul) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void onUserListDeletion(User user, UserList ul) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void onUserProfileUpdate(User user) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void onBlock(User user, User user1) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void onUnblock(User user, User user1) {
            throw new UnsupportedOperationException("Not supported yet.");
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
        twitter.sendTweet("Hmmmmm... This should work now.... Using the asynchronous API");
    }
}
