package io.etkinlik.api.client.model;

public class Venue {

    private int id;
    private String name;
    private String slug;
    private String about;

    private String lat;
    private String lng;

    private String phone;
    private String webUrl;
    private String facebook_url;
    private String twitter_url;

    private City city;
    private District district;
    private Neighborhood neighborhood;
    private String address;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSlug() {
        return slug;
    }

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public String getFacebookUrl() {
        return facebook_url;
    }

    public String getTwitterUrl() {
        return twitter_url;
    }

    public City getCity() {
        return city;
    }

    public District getDistrict() {
        return district;
    }

    public Neighborhood getNeighborhood() {
        return neighborhood;
    }

    public String getAddress() {
        return address;
    }
}
