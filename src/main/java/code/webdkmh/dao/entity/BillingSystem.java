package code.webdkmh.dao.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Billing_System")
public class BillingSystem {
    @EmbeddedId
    private BillingSystemId id;

    @Column(name = "Paymoney")
    private Double paymoney;

    @Column(name = "creadit")
    private Integer creadit;

    public Integer getCreadit() {
        return creadit;
    }

    public void setCreadit(Integer creadit) {
        this.creadit = creadit;
    }

    public Double getPaymoney() {
        return paymoney;
    }

    public void setPaymoney(Double paymoney) {
        this.paymoney = paymoney;
    }

    public BillingSystemId getId() {
        return id;
    }

    public void setId(BillingSystemId id) {
        this.id = id;
    }
}