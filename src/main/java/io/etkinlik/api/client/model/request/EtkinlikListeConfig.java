package io.etkinlik.api.client.model.request;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Vector;

public class EtkinlikListeConfig {

    private Vector<Integer> turIds = new Vector<>();
    private Vector<Integer> kategoriIds = new Vector<>();
    private Vector<Integer> mekanIds = new Vector<>();
    private Vector<Integer> sehirIds = new Vector<>();

    private int sayfa = 1;
    private int adet = 50;

    public HashMap<String, Object> parameters() {

        HashMap<String, Object> map = new HashMap<String, Object>();

        if ( ! turIds.isEmpty())
            map.put("turIds", StringUtils.join(turIds, ","));

        if ( ! kategoriIds.isEmpty())
            map.put("kategoriIds", StringUtils.join(kategoriIds, ","));

        if ( ! mekanIds.isEmpty())
            map.put("mekanIds", StringUtils.join(mekanIds, ","));

        if ( ! sehirIds.isEmpty())
            map.put("sehirIds", StringUtils.join(sehirIds, ","));

        map.put("sayfa", sayfa);
        map.put("adet", adet);

        return map;
    }

    public EtkinlikListeConfig addTurId(int turId) {
        this.turIds.add(turId);
        return this;
    }

    public EtkinlikListeConfig addKategoriId(int kategoriId) {
        this.kategoriIds.add(kategoriId);
        return this;
    }

    public EtkinlikListeConfig addMekanId(int mekanId) {
        this.mekanIds.add(mekanId);
        return this;
    }

    public EtkinlikListeConfig addSehirId(int sehirId) {
        this.sehirIds.add(sehirId);
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
