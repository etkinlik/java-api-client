package io.etkinlik.api.client.exception;

import io.etkinlik.api.client.model.response.exception.MovedResponse;

public class MovedException extends RuntimeException {
    private MovedResponse response;

    public MovedException(MovedResponse movedResponse) {
        super();
        this.response = movedResponse;
    }

    public MovedResponse getResponse() {
        return response;
    }
}
