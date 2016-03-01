package io.etkinlik.api.client.exception;

import io.etkinlik.api.client.model.response.exception.GoneResponse;

public class GoneException extends RuntimeException {

    private GoneResponse response;

    public GoneException(GoneResponse goneResponse) {

        super();
        this.response = goneResponse;
    }

    public GoneResponse getResponse() {
        return response;
    }
}
