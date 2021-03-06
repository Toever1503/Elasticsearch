package animenews.repository.relationship;

import animenews.entity.relationship.post.TermRelationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TermRelationshipRepository extends JpaRepository<TermRelationship, Long> {



}