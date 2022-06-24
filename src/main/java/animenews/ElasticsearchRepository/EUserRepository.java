package animenews.ElasticsearchRepository;

import animenews.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EUserRepository extends ElasticsearchRepository<User, Long> {

}