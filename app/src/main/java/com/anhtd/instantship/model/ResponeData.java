package com.anhtd.instantship.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by anhtd on 07/26/18.
 */

public class ResponeData implements Serializable {
    @SerializedName("data")
    private String data;
    @SerializedName("error_code")
    private int errorCode;
    @SerializedName("error_message")
    private String message;

    public ResponeData() {
    }

    public ResponeData(String data, int errorCode, String message) {
        this.data = data;
        this.errorCode = errorCode;
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
