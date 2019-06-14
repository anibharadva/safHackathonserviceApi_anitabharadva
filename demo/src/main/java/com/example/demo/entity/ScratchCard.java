package com.example.demo.entity;

/**
 * Anita
 * 6/12/2019
 */
import org.hibernate.annotations.NamedQuery;
import org.springframework.data.jpa.repository.Modifying;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Date;


@Entity
@Table(name = "card_master")
@NamedQuery(name = "ScratchCard.fetchBySerialNo",
        query = "SELECT c FROM ScratchCard c where c.serialNo = :serialNo ")

@NamedQuery(name = "ScratchCard.deleteInactiveCards",
        query = "delete FROM ScratchCard c where c.status =:status " )

public class ScratchCard {

    // TODO: Generate getters and setters...

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "scratch_card_id")
    private int scratchCardId;

    @Column(name = "voucher_number")
    private String voucherNumber;

    @Column(name = "serial_no")
    private String serialNo;

    @Column(name = "expiry_date")
    private String expiryDate;

    @Column(name = "voucher_amount")
    private double voucherAmount;

    @Column(name = "status")
    private String status;

    @Column(name = "date_created")
    private Timestamp dateCreated;

    @Column(name = "date_updated")
    private Timestamp dateUpdated;

    public String getVoucherNumber() {
        return voucherNumber;
    }

    public void setVoucherNumber(String voucherNumber) {
        this.voucherNumber = voucherNumber;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public double getVoucherAmount() {
        return voucherAmount;
    }

    public void setVoucherAmount(double voucherAmount) {
        this.voucherAmount = voucherAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = (Timestamp) dateCreated;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = (Timestamp) dateUpdated;
    }

    public int getScratchCardId() {
        return scratchCardId;
    }

    public void setScratchCardId(int scratchCardId) {
        this.scratchCardId = scratchCardId;
    }





}
