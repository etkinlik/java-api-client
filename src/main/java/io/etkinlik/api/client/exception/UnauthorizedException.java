package io.etkinlik.api.client.exception;

import io.etkinlik.api.client.model.response.exception.UnauthorizedResponse;

public class UnauthorizedException extends RuntimeException {

    private UnauthorizedResponse response;

    public UnauthorizedException(UnauthorizedResponse sonuc) {
        super();
        this.response = sonuc;
    }
    public UnauthorizedResponse getResponse() {
        return response;
    }
}
