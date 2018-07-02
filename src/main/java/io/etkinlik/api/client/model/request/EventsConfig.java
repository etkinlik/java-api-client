package io.etkinlik.api.client.model.request;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Vector;

public class EventsConfig {

    private Vector<Integer> formatIds = new Vector<>();
    private Vector<Integer> categoryIds = new Vector<>();
    private Vector<Integer> venueIds = new Vector<>();
    private Vector<Integer> cityIds = new Vector<>();

    private int skip = 1;
    private int take = 50;

    public HashMap<String, Object> parameters() {

        HashMap<String, Object> map = new HashMap<String, Object>();

        if (!formatIds.isEmpty())
            map.put("format_ids", StringUtils.join(formatIds, ","));

        if (!categoryIds.isEmpty())
            map.put("category_ids", StringUtils.join(categoryIds, ","));

        if (!venueIds.isEmpty())
            map.put("venue_ids", StringUtils.join(venueIds, ","));

        if (!cityIds.isEmpty())
            map.put("city_ids", StringUtils.join(cityIds, ","));

        map.put("skip", skip);
        map.put("take", take);

        return map;
    }

    public EventsConfig addFormatId(int turId) {
        this.formatIds.add(turId);
        return this;
    }

    public EventsConfig addCategoryId(int kategoriId) {
        this.categoryIds.add(kategoriId);
        return this;
    }

    public EventsConfig addVenueId(int mekanId) {
        this.venueIds.add(mekanId);
        return this;
    }

    public EventsConfig addCityId(int sehirId) {
        this.cityIds.add(sehirId);
        return this;
    }

    public EventsConfig setSkip(int skip) {
        this.skip = skip;
        return this;
    }

    public EventsConfig setTake(int take) {
        this.take = take;
        return this;
    }
}
