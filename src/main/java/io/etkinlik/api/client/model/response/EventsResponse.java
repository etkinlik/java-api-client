package io.etkinlik.api.client.model.response;

import io.etkinlik.api.client.model.Event;
import io.etkinlik.api.client.model.general.Meta;

public class EventsResponse {

    private Meta meta;
    private Event[] items;

    public Event[] getItems() {
        return items;
    }

    public Meta getMeta() {
        return meta;
    }

}
