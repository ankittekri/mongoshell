package com.seller.pojo;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.sql.Timestamp;


/**
 * Created by ankittekriwal on 10/10/15.
 */

@Entity(value = "buyer_service_reqs")
public class BuyerServiceRequest {


    private Timestamp requested_on;
    private String phone;
    private String alias;
    private String service;
    private String bid;

    public Timestamp getRequested_on() {
        return requested_on;
    }

    public void setRequested_on(Timestamp requested_on) {
        this.requested_on = requested_on;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }
}
