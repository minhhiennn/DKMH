package code.webdkmh.dao.repositories;

import code.webdkmh.dao.entities.UserKind;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
* Generated by Spring Data Generator on 12/02/2022
*/
@Repository
public interface UserKindRepository extends JpaRepository<UserKind, String>, JpaSpecificationExecutor<UserKind>, QuerydslPredicateExecutor<UserKind> {

}
