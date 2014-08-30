package internal.elasticSearch;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cassandra on 30/8/14.
 */
@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<Contact> getAllContacts() {
        Iterable<Contact> contactIterable = contactRepository.findAll();
        return Lists.newArrayList(contactIterable);
    }

    
}
