package internal.elasticSearch;

import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Created by cassandra on 30/8/14.
 */
@Document(indexName = "contactIndex")
public class Contact {

    private Long id;
    private String contactName;
    private String contactDetails;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }
}
