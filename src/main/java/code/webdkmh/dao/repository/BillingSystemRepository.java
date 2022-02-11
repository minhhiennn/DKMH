package code.webdkmh.dao.repository;

import code.webdkmh.dao.entity.BillingSystem;
import code.webdkmh.dao.entity.BillingSystemId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingSystemRepository extends JpaRepository<BillingSystem, BillingSystemId> {
}