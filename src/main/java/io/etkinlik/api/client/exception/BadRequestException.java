package io.etkinlik.api.client.exception;

import io.etkinlik.api.client.model.response.exception.BadRequestResponse;

public class BadRequestException extends RuntimeException {
    private BadRequestResponse response;

    public BadRequestException(BadRequestResponse genelHataResponse) {

        super();
        this.response = genelHataResponse;
    }

    public BadRequestResponse getResponse() {
        return response;
    }
}
