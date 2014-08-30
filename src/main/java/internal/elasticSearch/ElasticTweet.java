package internal.elasticSearch;

import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Created by cassandra on 30/8/14.
 */
@Document(indexName = "person", type = "user")
public class ElasticTweet {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
