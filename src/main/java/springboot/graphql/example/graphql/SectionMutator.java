package springboot.graphql.example.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springboot.graphql.example.data.DeltaLakeRepository;
import springboot.graphql.example.data.PostgresqlRepository;
import springboot.graphql.example.data.model.Section;

@Component
public class SectionMutator implements GraphQLMutationResolver {

    @Autowired
    private DeltaLakeRepository deltaLakeRepository;

    public Section insertSectionMutation(Integer sectionid, String sectionName, String sectionXID,  String courseXID) {
        Section section = deltaLakeRepository.insertSection(sectionid, sectionName, sectionXID, courseXID);
        return section;
    }

    public String deleteSectionMutation(Integer sectionid) {
        String response = deltaLakeRepository.deleteSection(sectionid);
        return response;
    }

}
