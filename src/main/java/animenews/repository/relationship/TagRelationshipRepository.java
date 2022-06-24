package animenews.repository.relationship;

import animenews.entity.relationship.post.TagRelationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TagRelationshipRepository extends JpaRepository<TagRelationship, Long> {


}