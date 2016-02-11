package io.etkinlik.api.client.exception;

import io.etkinlik.api.client.model.response.exception.BulunamadiResponse;

public class BulunamadiException extends RuntimeException {

    private BulunamadiResponse response;

    public BulunamadiException(BulunamadiResponse sonuc) {
        super();
        this.response = sonuc;
    }

    public BulunamadiResponse getResponse() {
        return response;
    }
}
