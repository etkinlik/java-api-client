package io.etkinlik.api.client.exception;

import io.etkinlik.api.client.model.response.exception.YetkilendirmeResponse;

public class YetkilendirmeException extends RuntimeException {

    private YetkilendirmeResponse response;

    public YetkilendirmeException(YetkilendirmeResponse sonuc) {
        super();
        this.response = sonuc;
    }
    public YetkilendirmeResponse getResponse() {
        return response;
    }
}
