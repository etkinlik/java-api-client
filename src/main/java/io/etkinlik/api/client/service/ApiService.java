package io.etkinlik.api.client.service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;
import io.etkinlik.api.client.ApiClient;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;

public class ApiService {

    private ApiClient client;

    public ApiService(ApiClient client) {
        this.client = client;
    }

    private GetRequest prepareGet(String address) {
        return Unirest
                .get("https://etkinlik.io/api/v1" + address)
                .header("X-ETKINLIK-TOKEN", client.getToken())
                .header("accept", "application/json")
                .header("Content-Type", "application/json");
    }

    public HttpResponse get(String address) throws UnirestException {

        return prepareGet(address).asJson();
    }

    public HttpResponse get(String address, HashMap<String, Object> properties) throws UnirestException {

        return prepareGet(address).queryString((Map<String, Object>) properties).asJson();
    }
}
