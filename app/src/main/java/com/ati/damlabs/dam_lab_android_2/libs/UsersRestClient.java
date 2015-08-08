package com.ati.damlabs.dam_lab_android_2.libs;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.apache.http.NameValuePair;

import java.util.ArrayList;

/**
 * Created by eric on 31/07/15.
 */



/**
 * Created by Juan on 7/19/2015.
 */
public class UsersRestClient {
    private static final String HOST = "http://inworknet.net:8000/api/";

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String url, RequestParams params, ArrayList<NameValuePair> headers, AsyncHttpResponseHandler responseHandler) {
        if(headers != null){
            for(int i = 0; i < headers.size(); i++){
                client.addHeader(headers.get(i).getName(), headers.get(i).getValue());
            }
        }
        client.setTimeout(1000*10);
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void post(String url, RequestParams params, ArrayList<NameValuePair> headers, AsyncHttpResponseHandler responseHandler) {
        if(headers != null){
            for(int i = 0; i < headers.size(); i++){
                client.addHeader(headers.get(i).getName(), headers.get(i).getValue());
            }
        }
        client.setTimeout(1000*10);
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void put(String url, RequestParams params, ArrayList<NameValuePair> headers, AsyncHttpResponseHandler responseHandler) {
        if(headers != null){
            for(int i = 0; i < headers.size(); i++){
                client.addHeader(headers.get(i).getName(), headers.get(i).getValue());
            }
        }
        client.setTimeout(1000*10);
        client.put(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void delete(String url, RequestParams params, ArrayList<NameValuePair> headers, AsyncHttpResponseHandler responseHandler) {
        if(headers != null){
            for(int i = 0; i < headers.size(); i++){
                client.addHeader(headers.get(i).getName(), headers.get(i).getValue());
            }
        }
        client.setTimeout(1000*10);
        client.put(getAbsoluteUrl(url), params, responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return HOST + relativeUrl;
    }
}
