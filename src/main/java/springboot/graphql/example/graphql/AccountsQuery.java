package springboot.graphql.example.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springboot.graphql.example.data.LinkRepository;
import springboot.graphql.example.data.PostgresqlRepository;
import springboot.graphql.example.data.model.Accounts;
import springboot.graphql.example.data.model.Link;

import java.util.List;

@Component
public class AccountsQuery implements GraphQLQueryResolver {

    @Autowired
    private PostgresqlRepository pqRepository;

    public Accounts AccountByIdQuery(Integer id) {

        return pqRepository.getAccountById(id);

    }

    public List<Accounts> AllAccounts() {

        return pqRepository.getAllAccounts();

    }
}
