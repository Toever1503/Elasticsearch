package animenews.repository;

import animenews.entity.relationship.user.UserAuthority;
import animenews.entity.relationship.user.UserAuthorityId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAuthorityRepository extends JpaRepository<UserAuthority, UserAuthorityId> {

}