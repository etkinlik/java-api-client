package io.etkinlik.api.client.exception;

import com.mashape.unirest.http.HttpResponse;

public class UnknownException extends RuntimeException {
    private HttpResponse response;
    public UnknownException(HttpResponse response) {
        super();
        this.response = response;
    }

    public HttpResponse getResponse() {
        return response;
    }
}
