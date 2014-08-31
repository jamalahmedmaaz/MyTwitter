package internal.elasticSearch;

import internal.Tweet;

import java.util.List;

/**
 * Created by cassandra on 31/8/14.
 */
public interface ElasticTweetService {
    List<? extends Tweet> findAll();

}
