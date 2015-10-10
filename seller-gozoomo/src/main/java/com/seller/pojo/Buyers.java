package com.seller.pojo;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.bson.types.ObjectId;
import java.util.List;


/**
 * Created by ankittekriwal on 10/10/15.
 */

@Entity(value = "buyers")
public class Buyers {


    private String phone;
    private List<String> bids;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<String> getBids() {
        return bids;
    }

    public void setBids(List<String> bids) {
        this.bids = bids;
    }
}
