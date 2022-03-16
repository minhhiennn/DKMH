package code.webdkmh.dao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import code.webdkmh.dao.entities.SubPass;
import code.webdkmh.dao.entities.SubPassId;

public interface SubPassRepository extends JpaRepository<SubPass, SubPassId> {

    @Query("SELECT p FROM SubPass p WHERE  p.idStudent = ?1")
    List<SubPass> findByID_Student(String idStudent);
}