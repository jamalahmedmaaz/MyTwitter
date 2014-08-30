package internal;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * User: Jamal
 * Date: 7/22/14
 * Time: 2:47 AM
 */
@Repository
public class HBaseTweetRepositoryImpl implements HBaseTweetRepository {

    public HBaseTweetRepositoryImpl() {
        configureApplication();
    }

    private void configureApplication() {
        Configuration conf = HBaseConfiguration.create();
        try {
            HBaseAdmin admin = new HBaseAdmin(conf);
            HTableDescriptor tableDescriptor = new HTableDescriptor("users".getBytes());
            tableDescriptor.addFamily(new HColumnDescriptor("username"));
            tableDescriptor.addFamily(new HColumnDescriptor("password"));
            admin.createTable(tableDescriptor);
        } catch (MasterNotRunningException e) {
        } catch (ZooKeeperConnectionException e) {
        } catch (IOException e) {
        }
    }

    @Override
    public String getPassword(String username) {
        Configuration conf = HBaseConfiguration.create();
        try {
            HTable table = new HTable(conf, "users");
            Get get = new Get(Bytes.toBytes(username));
            get.addFamily(Bytes.toBytes("username"));
            get.setMaxVersions(3);
            Result result = table.get(get);
            byte[] row = result.getRow();
            return row != null ? new String(row) : null;
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    @Override
    public List<String> getFriends(String username) {
        return null;
    }

    @Override
    public List<String> getFollowers(String username) {
        return null;
    }

    @Override
    public List<CassandraTweet> getUserline(String username, Date start, int limit) {
        return null;
    }

    @Override
    public List<CassandraTweet> getTimeline(String username, Date start, int limit) {
        return null;
    }

    @Override
    public List<CassandraTweet> getTweets(Date start, int limit) {
        return null;
    }

    @Override
    public CassandraTweet getTweet(UUID id) {
        return null;
    }

    @Override
    public void saveUser(String username, String password) {

    }

    @Override
    public CassandraTweet saveTweet(String username, String body) {
        return null;
    }

    @Override
    public void addFriend(String username, String friend) {

    }

    @Override
    public void removeFriend(String username, String friend) {

    }
}
