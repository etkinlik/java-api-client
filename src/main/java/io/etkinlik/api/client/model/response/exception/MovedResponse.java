package io.etkinlik.api.client.model.response.exception;

public class MovedResponse {

    private boolean success;
    private String message;
    private int new_id;
    private String new_name;
    private String new_slug;

    public boolean getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public int getNewId() {
        return new_id;
    }

    public String getNewName() {
        return new_name;
    }

    public String getNewSlug() {
        return new_slug;
    }
}
