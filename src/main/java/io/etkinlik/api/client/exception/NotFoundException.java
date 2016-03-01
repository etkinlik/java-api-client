package io.etkinlik.api.client.exception;

import io.etkinlik.api.client.model.response.exception.NotFoundResponse;

public class NotFoundException extends RuntimeException {

    private NotFoundResponse response;

    public NotFoundException(NotFoundResponse sonuc) {
        super();
        this.response = sonuc;
    }

    public NotFoundResponse getResponse() {
        return response;
    }
}
