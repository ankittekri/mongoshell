package com.seller.service;

import com.seller.pojo.*;
import com.seller.util.FreshDeskUpdate;
import com.seller.util.MixPanelData;
import org.springframework.beans.factory.annotation.Autowired;
import com.seller.dao.SellerDao;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


@Path("/getSellerDetails/{uuid}")
public class SellerService {

    @Autowired
    SellerDao sellerDao;

    @Autowired
    ErrorMessage errorMessage;

    @GET
    @Path("/car_classifieds")
    @Produces(MediaType.APPLICATION_JSON)
    public CarClassifieds getSeller(@PathParam("uuid") String uuid) {


        Response errorResponse = Response.status(Response.Status.NOT_FOUND)
                .entity(errorMessage)
                .build();
        CarClassifieds carClassifieds = sellerDao.read(uuid);


        if (carClassifieds == null) {

            throw new WebApplicationException(errorResponse);
        }

        return seller;

    }

    @GET
    @Path("/buyer_service_reqs")
    @Produces(MediaType.APPLICATION_JSON)
    public List<BuyerServiceRequest> getBidDetails(@QueryParam("car_alias") String car_alias) {


        Map<String, BuyerServiceRequest> distinctBids = new HashMap<String, BuyerServiceRequest>();
        Response errorResponse = Response.status(Response.Status.NOT_FOUND)
                .entity(errorMessage)
                .build();
        List<BuyerServiceRequest> buyers = sellerDao.readBuyers(car_alias);

        for (BuyerServiceRequest distinct : buyers) {

            BuyerServiceRequest previousRecord = distinctBids.get(distinct.getPhone());
            if (previousRecord == null)
                distinctBids.put(distinct.getPhone(), distinct);

            else {

                Timestamp previousRecordTime = previousRecord.getRequested_on();

                if (distinct.getRequested_on().after(previousRecordTime))
                    distinctBids.put(distinct.getPhone(), distinct);
            }

        }

        List<BuyerServiceRequest> ModifiedBuyers = new ArrayList<BuyerServiceRequest>(distinctBids.values());

        // if (ModifiedBuyers == null !! ModifiedBuyers.isEmpty())
        if (ModifiedBuyers == null) {

            throw new WebApplicationException(errorResponse);
        }

        return ModifiedBuyers;

    }


    @GET
    @Path("/buyers")
    @Produces(MediaType.APPLICATION_JSON)
    public Buyers getBuyers(@QueryParam("phone") String phone) {


        Response errorResponse = Response.status(Response.Status.NOT_FOUND)
                .entity(errorMessage)
                .build();
        Buyers buyers = sellerDao.readBuyer(phone);


        if (buyers == null) {

            throw new WebApplicationException(errorResponse);
        }

        return buyers;

    }


    @GET
    @Path("/update_price")
    @Produces(MediaType.APPLICATION_JSON)
    public Response logFreshDeskTicket(@QueryParam("phone") String phone) {

        return FreshDeskUpdate.logTicket(phone);

    }

    @GET
    @Path("/mixpanel_data")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMixPanelData(@QueryParam("car_alias") String car_alias) {
       return MixPanelData.getMixPanelData(car_alias);

    }
}