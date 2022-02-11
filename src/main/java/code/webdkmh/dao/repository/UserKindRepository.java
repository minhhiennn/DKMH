package code.webdkmh.dao.repository;

import code.webdkmh.dao.entity.UserKind;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserKindRepository extends JpaRepository<UserKind, String> {
}