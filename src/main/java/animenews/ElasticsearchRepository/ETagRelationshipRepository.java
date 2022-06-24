package animenews.ElasticsearchRepository;

import animenews.entity.relationship.post.TagRelationship;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ETagRelationshipRepository extends ElasticsearchRepository<TagRelationship, Long> {


}