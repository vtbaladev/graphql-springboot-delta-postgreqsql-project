package springboot.graphql.example.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springboot.graphql.example.data.LinkRepository;
import springboot.graphql.example.data.PostgresqlRepository;
import springboot.graphql.example.data.model.Accounts;
import springboot.graphql.example.data.model.Link;

@Component
public class AccountsMutator implements GraphQLMutationResolver {

    @Autowired
    private PostgresqlRepository pqRepository;

    public Accounts insertAccountsMutation(Integer id, String name, String coursexid, String email, String section) {
        Accounts account = pqRepository.insertAccounts(id, name, coursexid, email, section);
        return account;
    }

    public String deleteAccounts(Integer id) {
        String response = pqRepository.deleteAccounts(id);
        return response;
    }

}
