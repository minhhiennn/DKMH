package code.webdkmh.dao.repositories;

import code.webdkmh.dao.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, String> {
}