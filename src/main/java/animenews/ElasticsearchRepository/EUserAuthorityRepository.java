package animenews.ElasticsearchRepository;

import animenews.entity.relationship.user.UserAuthority;
import animenews.entity.relationship.user.UserAuthorityId;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EUserAuthorityRepository extends ElasticsearchRepository<UserAuthority, UserAuthorityId> {

}