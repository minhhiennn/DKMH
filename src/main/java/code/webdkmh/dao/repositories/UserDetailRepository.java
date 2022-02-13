package code.webdkmh.dao.repositories;

import code.webdkmh.dao.entities.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailRepository extends JpaRepository<UserDetail, String> {
}