package code.webdkmh.dao.repositories;

import code.webdkmh.dao.entities.UserKind;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserKindRepository extends JpaRepository<UserKind, String> {
}