package io.etkinlik.api.client.model.request;

import java.util.HashMap;

public class EtkinlikListeConfig {
    private int turId;
    private int kategoriId;
    private int mekanId;
    private int sehirId;
    private int sayfa = 1;
    private int adet = 50;

    public HashMap<String, Object> parameters() {

        HashMap<String, Object> map = new HashMap<String, Object>();

        map.put("turId", turId);
        map.put("kategoriId", kategoriId);
        map.put("mekanId", mekanId);
        map.put("sehirId", sehirId);
        map.put("sayfa", sayfa);
        map.put("adet", adet);

        return map;
    }

    public EtkinlikListeConfig setTurId(int turId) {
        this.turId = turId;
        return this;
    }

    public EtkinlikListeConfig setKategoriId(int kategoriId) {
        this.kategoriId = kategoriId;
        return this;
    }

    public EtkinlikListeConfig setMekanId(int mekanId) {
        this.mekanId = mekanId;
        return this;
    }

    public EtkinlikListeConfig setSehirId(int sehirId) {
        this.sehirId = sehirId;
        return this;
    }

    public EtkinlikListeConfig setSayfa(int sayfa) {
        this.sayfa = sayfa;
        return this;
    }

    public EtkinlikListeConfig setAdet(int adet) {
        this.adet = adet;
        return this;
    }
}
