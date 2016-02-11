package io.etkinlik.api.client.model;

public class Mekan {

    private int id;
    private String adi;
    private String radi;
    private String adresi;
    private String lat;
    private String lng;
    private String telefon;
    private String websitesi;
    private String facebook;
    private String twitter;

    private Ilce ilce;

    private Semt semt;

    public int getId() {
        return id;
    }

    public String getAdi() {
        return adi;
    }

    public String getRadi() {
        return radi;
    }

    public String getAdresi() {
        return adresi;
    }

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getWebsitesi() {
        return websitesi;
    }

    public String getFacebook() {
        return facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public Ilce getIlce() {
        return ilce;
    }

    public Semt getSemt() {
        return semt;
    }
}
