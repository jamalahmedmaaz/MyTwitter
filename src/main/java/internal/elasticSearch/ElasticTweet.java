/*
 * Copyright 2013, Matt Brozowski and Eric Evans
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package internal.elasticSearch;

import internal.Tweet;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

@Document(indexName = "tweetIndex")
public class ElasticTweet implements Comparable<ElasticTweet>, Tweet {

    private final Integer id;
    private final Date postedAt;
    private final String postedBy;
    private final String body;

    public ElasticTweet(String postedBy, String body, Integer id, Date postedAt) {
        this.postedBy = postedBy;
        this.body = body;
        this.id = id;
        this.postedAt = postedAt;
    }

    public Integer getId() {
        return id;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public String getBody() {
        return body;
    }

    public Date getPostedAt() {
        return postedAt;
    }

    public int compareTo(ElasticTweet o) {
        return this.postedAt.compareTo(o.postedAt);
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        buf.append(postedBy).append(": ").append(body).append(" (").append(postedAt).append(")");
        return buf.toString();
    }
}
