package com.seller.util;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * Created by ankittekriwal on 11/10/15.
 */
public class MixPanelData {

    public static final String API_KEY = "";
    public static final String API_SECRET = "";
   // public static final String SegmentationUrl = "http://mixpanel.com/api/2.0/segmentation/sum/";


public static Response getMixPanelData(String car_alias){


    CloseableHttpClient httpclient = HttpClients.createDefault();
 //   HttpGet httpget = new HttpGet(SegmentationUrl);
    URIBuilder uri = new URIBuilder()
            .setScheme("http")
            .setHost("www.mixpanel.com")
            .setPath("/api/2.0/segmentation/sum/")
            .setParameter("event", "httpclient")
            .setParameter("from_date", "")
            .setParameter("to_date", "")
            .setParameter("on", "")
            .setParameter("unit","")
            .setParameter("where","")
            .build();

    HttpGet httpget = new HttpGet(uri);

    System.out.println(httpget.getURI());

    CloseableHttpResponse response = httpclient.execute(httpget);

    return response;


}


}
