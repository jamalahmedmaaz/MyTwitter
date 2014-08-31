package internal.elasticSearch;

import internal.Tweet;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by cassandra on 30/8/14.
 */

public interface ElasticTweetRepository extends ElasticsearchRepository<Tweet, String> {
}
