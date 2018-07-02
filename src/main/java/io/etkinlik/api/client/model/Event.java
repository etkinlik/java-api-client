package io.etkinlik.api.client.model;

public class Event {

    private int id;
    private String name;
    private String slug;
    private String url;
    private String content;
    private String start;
    private String end;
    private boolean is_free;

    private String phone;
    private String email;
    private String facebook_url;
    private String twitter_url;
    private String hashtag;
    private String web_url;
    private String live_url;
    private String android_url;
    private String ios_url;

    private Format tur;

    private Category kategori;

    private Venue mekan;

    private Tag[] etiketler;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSlug() {
        return slug;
    }

    public String getUrl() {
        return url;
    }

    public String getContent() {
        return content;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public boolean isIsFree() {
        return is_free;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getFacebookUrl() {
        return facebook_url;
    }

    public String getTwitterUrl() {
        return twitter_url;
    }

    public String getHashtag() {
        return hashtag;
    }

    public String getWebUrl() {
        return web_url;
    }

    public String getLiveUrl() {
        return live_url;
    }

    public String getAndroidUrl() {
        return android_url;
    }

    public String getIosUrl() {
        return ios_url;
    }

    public Format getTur() {
        return tur;
    }

    public Category getKategori() {
        return kategori;
    }

    public Venue getMekan() {
        return mekan;
    }

    public Tag[] getEtiketler() {
        return etiketler;
    }
}
