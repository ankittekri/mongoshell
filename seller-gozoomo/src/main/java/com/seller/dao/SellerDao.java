package com.seller.dao;

import com.seller.pojo.BuyerServiceRequest;
import com.seller.pojo.Buyers;
import com.seller.pojo.CarClassifieds;
import java.util.List;


/**
 * Created by ankittekriwal on 8/10/15.
 */
public interface SellerDao {


    public CarClassifieds read(String uuid);
    public List<BuyerServiceRequest> readBuyerServiceRequest(String car_alias);
    public Buyers readBuyer(String phone);


}
