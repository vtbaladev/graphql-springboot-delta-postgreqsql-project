package springboot.graphql.example.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springboot.graphql.example.data.LinkRepository;
import springboot.graphql.example.data.PostgresqlRepository;
import springboot.graphql.example.data.model.Accounts;
import springboot.graphql.example.data.model.Link;

@Component
public class LinkMutator implements GraphQLMutationResolver {

    @Autowired
    private LinkRepository linkRepository;

//    @Autowired
//    private PostgresqlRepository pqRepository;

    public Link linkCreate(String url, String description) {
        Link link = new Link(url, description);
        linkRepository.save(link);
        return link;
    }

//    public Accounts insertAccountsMutation(int id, String name, String coursexid, String email, String section) {
//        Accounts account = pqRepository.insertAccounts(id, name, coursexid, email, section);
//        return account;
//    }
}

