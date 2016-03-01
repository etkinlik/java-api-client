package io.etkinlik.api.client.model;

import io.etkinlik.api.client.model.etkinlik.Ozellik;

public class Etkinlik {

    private int id;
    private String adi;
    private String radi;
    private String url;
    private String icerik;
    private String baslangic;
    private String bitis;
    private boolean ucretliMi;
    private int durum;

    private Ozellik ozellik;

    private Tur tur;

    private Kategori kategori;

    private Mekan mekan;

    private Etiket[] etiketler;

    public int getId() {
        return id;
    }

    public String getAdi() {
        return adi;
    }

    public String getRadi() {
        return radi;
    }

    public String getUrl() {
        return url;
    }

    public String getIcerik() {
        return icerik;
    }

    public String getBaslangic() {
        return baslangic;
    }

    public String getBitis() {
        return bitis;
    }

    public boolean isUcretliMi() {
        return ucretliMi;
    }

    public int getDurum() {
        return durum;
    }

    public Ozellik getOzellik() {
        return ozellik;
    }

    public Tur getTur() {
        return tur;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public Mekan getMekan() {
        return mekan;
    }

    public Etiket[] getEtiketler() {
        return etiketler;
    }
}
