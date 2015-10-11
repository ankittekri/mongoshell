package com.seller.service;

import com.seller.pojo.*;
import com.seller.util.FreshDeskUpdate;
import com.seller.util.MixPanelData;
import org.apache.http.HttpResponse;
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
import org.apache.http.HttpResponse;
import javax.ws.rs.core.GenericEntity;



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

        return carClassifieds;

    }

    @GET
    @Path("/buyer_service_reqs")
    @Produces(MediaType.APPLICATION_JSON)
    public List<BuyerServiceRequest> getBidDetails(@QueryParam("car_alias") String car_alias) {


        Map<String, BuyerServiceRequest> distinctBids = new HashMap<String, BuyerServiceRequest>();
        Response errorResponse = Response.status(Response.Status.NOT_FOUND)
                .entity(errorMessage)
                .build();
        List<BuyerServiceRequest> buyers = sellerDao.readBuyerServiceRequest(car_alias);

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
        Buyers buyers = sellerDao.readBuyers(phone);


        if (buyers == null) {

            throw new WebApplicationException(errorResponse);
        }

        return buyers;

    }


    @GET
    @Path("/update_price")
    @Produces(MediaType.APPLICATION_JSON)
    public Response logFreshDeskTicket(@QueryParam("phone") String phone) {

        List responseList = FreshDeskUpdate.logTicket(phone);

        return Response.status(Response.Status.OK).entity(responseList.toString()).build();

    }

    @GET
    @Path("/mixpanel_data")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMixPanelData(@QueryParam("car_alias") String car_alias) {

        List responseList = MixPanelData.getMixPanelData(car_alias);

        return Response.status(Response.Status.OK).entity(responseList.toString()).build();

    }
}