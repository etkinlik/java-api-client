package io.etkinlik.api.client.model.response.exception;

public class NotFoundResponse {
    private boolean success;
    private String message;

    public boolean getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
