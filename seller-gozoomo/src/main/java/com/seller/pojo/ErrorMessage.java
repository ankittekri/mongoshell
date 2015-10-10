package com.seller.pojo;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * Created by ankittekriwal on 9/10/15.
 */


@XmlRootElement
public class ErrorMessage {


    private int error_code;
    private String message;

    public ErrorMessage(){

        this.error_code = 404;
        this.message = "Wrong UUID - Seller with this UUID does not exist";

    }


    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
