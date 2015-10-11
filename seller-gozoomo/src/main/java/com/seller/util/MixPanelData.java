package com.seller.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import javax.imageio.IIOException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by ankittekriwal on 11/10/15.
 */
public class MixPanelData {

    public static final String API_KEY = "";
    public static final String API_SECRET = "";
   // public static final String SegmentationUrl = "http://mixpanel.com/api/2.0/segmentation/sum/";


public static HttpResponse getMixPanelData(String car_alias){


    CloseableHttpClient httpclient = HttpClients.createDefault();
 //   HttpGet httpget = new HttpGet(SegmentationUrl);
    URI uri=null;
    CloseableHttpResponse response= null;
    try {
         uri = new URIBuilder()
                .setScheme("http")
                .setHost("www.mixpanel.com")
                .setPath("/api/2.0/segmentation/sum/")
                .setParameter("event", "httpclient")
                .setParameter("from_date", "")
                .setParameter("to_date", "")
                .setParameter("on", "")
                .setParameter("unit", "")
                .setParameter("where", "")
                .build();
    }
    catch(URISyntaxException uriSyntaxException){
        System.out.println(uriSyntaxException.getMessage());

    }
    HttpGet httpget = new HttpGet(uri);

    System.out.println(httpget.getURI());

    try {
        response = httpclient.execute(httpget);
    }
    catch(IOException iOException){

    }

    finally{
        return response;
    }


}


}
