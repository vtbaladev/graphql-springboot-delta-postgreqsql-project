package springboot.graphql.example.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springboot.graphql.example.data.DeltaLakeRepository;
import springboot.graphql.example.data.PostgresqlRepository;
import springboot.graphql.example.data.model.Section;

import java.util.List;

@Component
public class SectionQuery implements GraphQLQueryResolver {

    @Autowired
    private DeltaLakeRepository deltaLakeRepository;

    public Section SectionById(Integer id) {

        return deltaLakeRepository.getSectionById(id);

    }

    public List<Section> AllSections() {

        return deltaLakeRepository.getAllSection();

    }
}
