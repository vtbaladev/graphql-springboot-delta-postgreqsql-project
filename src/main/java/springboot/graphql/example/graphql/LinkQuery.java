package springboot.graphql.example.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springboot.graphql.example.data.DeltaLakeRepository;
import springboot.graphql.example.data.LinkRepository;
import springboot.graphql.example.data.PostgresqlRepository;
import springboot.graphql.example.data.model.Accounts;
import springboot.graphql.example.data.model.Link;

import java.util.List;

@Component
public class LinkQuery implements GraphQLQueryResolver {

    @Autowired
    private LinkRepository linkRepository;
    @Autowired
    public PostgresqlRepository pqRepository;

    @Autowired
    public DeltaLakeRepository deltaLakeRepository;

    public List<Link> allLinks() {
        pqRepository.getAccountById(4);
//        deltaLakeRepository.executeDeltaQuery();
//        pqRepository.insertAccounts(4,"victor", "xidcomputer", "victor@mail.com", "section4");
        return linkRepository.findAll();

    }

//    public Accounts AccountByIdQuery(Integer id) {
//
//        return pqRepository.getAccountById(id);
//
//    }
}
