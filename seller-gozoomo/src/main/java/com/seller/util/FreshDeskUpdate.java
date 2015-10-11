package com.seller.util;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import javax.json.Json;
import javax.json.JsonObject;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Base64.Encoder;
import java.util.Base64;
import javax.json.JsonBuilderFactory;


/**
 * Created by ankittekriwal on 11/10/15.
 */
public class FreshDeskUpdate {

    public static final String API_KEY = "";
    public static final String API_SECRET = "";
    public static final String FreshdeskUrl = "https://domain.freshdesk.com/helpdesk/tickets.json";
    public static final String freshDeskCredential = "user:password";


    public static HttpResponse logTicket(String car_alias) {

       // String basicAuth = Base64.encodeBase64String(freshDeskCredential.getBytes());
        String basicAuth = (Base64.getEncoder().encode(freshDeskCredential.getBytes())).toString();
        CloseableHttpResponse response= null;
       // JsonBuilderFactory factory = Json.createBuilderFactory(config);
        JsonObject ticket = Json.createObjectBuilder()
                .add("helpdesk_ticket", Json.createObjectBuilder()
                        .add("description", "description")
                        .add("subject","subject")
                        .add("email","email")
                        .add("priority","priority")
                        .add("priority", "priority"))
                .add("cc_emails", "xyz@freshdesk.com, abc@freshdesk.com")
                .build();

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPostRequest = new HttpPost(FreshdeskUrl);
        httpPostRequest.setHeader("Authorization", "Basic " + basicAuth);
        httpPostRequest.addHeader("Content-Type", "application/json");
        httpPostRequest.addHeader("Accept", "application/json");

        try {
            httpPostRequest.setEntity(new StringEntity(ticket.toString()));
        }

        catch(UnsupportedEncodingException unsupExcep){

        }
            System.out.println(httpPostRequest);

        try {

            response = httpclient.execute(httpPostRequest);
        }
        catch(IOException iOException){

        }
        finally{
            return response;
        }

    }
}