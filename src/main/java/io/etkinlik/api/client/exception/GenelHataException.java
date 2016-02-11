package io.etkinlik.api.client.exception;

import io.etkinlik.api.client.model.response.exception.GenelHataResponse;

public class GenelHataException extends RuntimeException {
    private GenelHataResponse response;

    public GenelHataException(GenelHataResponse genelHataResponse) {

        super();
        this.response = genelHataResponse;
    }

    public GenelHataResponse getResponse() {
        return response;
    }
}
