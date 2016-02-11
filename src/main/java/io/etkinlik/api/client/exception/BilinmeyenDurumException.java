package io.etkinlik.api.client.exception;

import com.mashape.unirest.http.HttpResponse;

/**
 * Created by irfan on 2/11/16.
 */
public class BilinmeyenDurumException extends RuntimeException {
    private HttpResponse response;
    public BilinmeyenDurumException(HttpResponse response) {
        super();
        this.response = response;
    }

    public HttpResponse getResponse() {
        return response;
    }
}
