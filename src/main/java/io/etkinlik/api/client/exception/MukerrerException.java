package io.etkinlik.api.client.exception;

import io.etkinlik.api.client.model.response.exception.MukerrerResponse;

public class MukerrerException extends RuntimeException {
    private MukerrerResponse response;

    public MukerrerException(MukerrerResponse mukerrerResponse) {
        super();
        this.response = mukerrerResponse;
    }

    public MukerrerResponse getResponse() {
        return response;
    }
}
