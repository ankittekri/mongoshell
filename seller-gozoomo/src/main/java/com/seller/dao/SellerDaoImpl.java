package com.seller.dao;

import com.mongodb.MongoClient;
import com.seller.pojo.*;
import org.mongodb.morphia.Morphia;
import org.springframework.beans.factory.annotation.Autowired;
import org.mongodb.morphia.Datastore;

import java.util.List;


/**
 * Created by ankittekriwal on 9/10/15.
 */
public class SellerDaoImpl implements SellerDao {

    private final String DB_NAME = "test";

    @Autowired
    private Morphia morphia;


    @Autowired
    private MongoClient mongoClient;

    @Override
    public CarClassifieds read(String uuid) {


        Datastore datastore = morphia.createDatastore(mongoClient, DB_NAME);
        return datastore.createQuery(CarClassifieds.class).filter("uuid =", uuid).get();


    }


    @Override
    public List<BuyerServiceRequest> readBuyerServiceRequest(String car_alias) {

        Datastore datastore = morphia.createDatastore(mongoClient, DB_NAME);
        return datastore.createQuery(BuyerServiceRequest.class).filter("service =", "negotiation").filter("alias =", car_alias).asList();

    }


    @Override
    public Buyers readBuyers(String phone) {

        Datastore datastore = morphia.createDatastore(mongoClient, DB_NAME);
        return datastore.createQuery(Buyers.class).filter("phone =", phone).get();


    }
}
