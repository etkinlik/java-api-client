package io.etkinlik.api.client.exception;

import io.etkinlik.api.client.model.response.YetkilendirmeHatasiSonuc;

public class YetkilendirmeException extends RuntimeException {

    private YetkilendirmeHatasiSonuc sonuc;

    public YetkilendirmeException(YetkilendirmeHatasiSonuc sonuc) {

        // elde json var

        super();

        this.sonuc = sonuc;
    }

    public YetkilendirmeHatasiSonuc getSonuc() {
        return sonuc;
    }
}
