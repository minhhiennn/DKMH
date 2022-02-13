package code.webdkmh.dao.repositories;

import code.webdkmh.dao.entities.UserHasRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserHasRoleRepository extends JpaRepository<UserHasRole, String> {
}