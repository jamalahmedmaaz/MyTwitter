package internal;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * User: Jamal
 * Date: 7/22/14
 * Time: 2:47 AM
 */
public interface HBaseTweetRepository {
    String getPassword(String username);

    List<String> getFriends(String username);

    List<String> getFollowers(String username);

    /**
     * Returns a userline.  A userline is a materialized view of the
     * tweets made by a specific user.
     *
     * @param username the user this view pertains to.
     * @param start    the starting date; the most recent tweet to include.
     * @param limit    maximum number of tweets to return.
     * @return a list of Tweet instances.
     */
    List<CassandraTweet> getUserline(String username, Date start, int limit);

    /**
     * Returns a timeline.  A timeline is the materialized view of tweets made
     * by the friends of a specific user.
     *
     * @param username the user this view pertains to.
     * @param start    the starting date; the most recent tweet to include.
     * @param limit    maximum number of tweets to return.
     * @return a list of Tweet instances.
     */
    List<CassandraTweet> getTimeline(String username, Date start, int limit);

    List<CassandraTweet> getTweets(Date start, int limit);

    CassandraTweet getTweet(UUID id);

    void saveUser(String username, String password);

    CassandraTweet saveTweet(String username, String body);

    void addFriend(String username, String friend);

    void removeFriend(String username, String friend);

}
