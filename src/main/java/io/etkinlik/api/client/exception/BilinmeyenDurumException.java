package io.etkinlik.api.client.exception;

import com.mashape.unirest.http.HttpResponse;

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
