package com.seller.pojo;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * Created by ankittekriwal on 9/10/15.
 */

@Entity(value = "car_classifieds")
public class CarClassifieds {

    private String make;
    private String[] images;
    private String owner_number;
    private String publish_status;
    private String city;
    private String listed_on;
    private String seller_name;
    private String seller_phone;
    private Long car_listed_price;
    private int year;
    private Long page_view_count;
    private String version;
    private String location;
    private String model;
    private String uuid;
    private String alias;


    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }

    public String getOwner_number() {
        return owner_number;
    }

    public void setOwner_number(String owner_number) {
        this.owner_number = owner_number;
    }

    public String getPublish_status() {
        return publish_status;
    }

    public void setPublish_status(String publish_status) {
        this.publish_status = publish_status;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getListed_on() {
        return listed_on;
    }

    public void setListed_on(String listed_on) {
        this.listed_on = listed_on;
    }

    public String getSeller_name() {
        return seller_name;
    }

    public void setSeller_name(String seller_name) {
        this.seller_name = seller_name;
    }

    public String getSeller_phone() {
        return seller_phone;
    }

    public void setSeller_phone(String seller_phone) {
        this.seller_phone = seller_phone;
    }

    public Long getCar_listed_price() {
        return car_listed_price;
    }

    public void setCar_listed_price(Long car_listed_price) {
        this.car_listed_price = car_listed_price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Long getPage_view_count() {
        return page_view_count;
    }

    public void setPage_view_count(Long page_view_count) {
        this.page_view_count = page_view_count;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
