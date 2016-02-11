package io.etkinlik.api.client.model.response;

import io.etkinlik.api.client.model.Etkinlik;

public class EtkinlikListeResponse {
    private Sayfalama sayfalama;
    private Etkinlik[] kayitlar;

    public Etkinlik[] getKayitlar() {
        return kayitlar;
    }

    public Sayfalama getSayfalama() {
        return sayfalama;
    }
}
