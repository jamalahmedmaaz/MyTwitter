package internal.elasticSearch;

import com.google.common.collect.Lists;
import internal.Tweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cassandra on 31/8/14.
 */
@Service
public class ElasticTweetServiceImpl implements ElasticTweetService {

    @Autowired
    private ElasticTweetRepository elasticTweetRepository;

    @Override
    public List<? extends Tweet> findAll() {
        return Lists.newArrayList(elasticTweetRepository.findAll());
    }
}
