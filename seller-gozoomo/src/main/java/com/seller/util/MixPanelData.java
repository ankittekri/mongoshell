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
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

/**
 * Created by ankittekriwal on 11/10/15.
 */
public class MixPanelData {

    public static final String API_KEY = "";
    public static final String API_SECRET = "";
   // public static final String SegmentationUrl = "http://mixpanel.com/api/2.0/segmentation/sum/";


public static List getMixPanelData(String car_alias){


    CloseableHttpClient httpclient = HttpClients.createDefault();
 //   HttpGet httpget = new HttpGet(SegmentationUrl);
    List statusList = new ArrayList();

    URI uri=null;
    CloseableHttpResponse response= null;
    try {
         uri = new URIBuilder()
                .setScheme("https")
                .setHost("mixpanel.com")
                .setPath("/api/2.0/segmentation")
                .setParameter("event", "car_details_seen")
                 .setParameter("type", "general")
                .setParameter("from_date", "2014-10-11")
                .setParameter("to_date", "2015-10-11")
               // .setParameter("on", "")
                //.setParameter("where", "")
                 .setParameter("api_key", "")
                 .setParameter("unit", "month")
                 .setParameter("expire","1444583006")
                 .setParameter("sig","")
                 .build();
    }
    catch(URISyntaxException uriSyntaxException){
        System.out.println(uriSyntaxException.getMessage());

    }
    HttpGet httpget = new HttpGet(uri);

    System.out.println(httpget.getURI());

    try {
        response = httpclient.execute(httpget);
        HttpEntity httpEntity = response.getEntity();
        String apiOutput = EntityUtils.toString(httpEntity);
        statusList.add("status : "+ response.getStatusLine());
        statusList.add("content : "+ apiOutput);
    }
    catch(IOException iOException){

    }

    finally{
        return statusList;
    }


}


}
