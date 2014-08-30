package internal.elasticSearch;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by cassandra on 30/8/14.
 */

interface ElasticTweetRepository extends ElasticsearchRepository<ElasticTweet, String> {
}
