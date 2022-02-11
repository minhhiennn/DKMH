package code.webdkmh.dao.repository;

import code.webdkmh.dao.entity.SubPass;
import code.webdkmh.dao.entity.SubPassId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubPassRepository extends JpaRepository<SubPass, SubPassId> {
}