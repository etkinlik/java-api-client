package io.etkinlik.api.client;

import com.google.gson.Gson;
import io.etkinlik.api.client.service.ApiService;
import io.etkinlik.api.client.service.EventService;
import io.etkinlik.api.client.service.FormatService;

public class ApiClient {

    private String token;
    private Gson gson;

    private static EventService eventService = null;
    private static ApiService apiService = null;
    private static FormatService formatService = null;


    public ApiClient(String token) {
        this.token = token;
        gson = new Gson();
    }

    public EventService getEventService() {
        if (eventService == null) {
            eventService = new EventService(this);
        }
        return eventService;
    }

    public FormatService getFormatService() {
        if (formatService == null) {
            formatService = new FormatService(this);
        }
        return formatService;
    }

    public ApiService getApiService() {
        if (apiService == null) {
            apiService = new ApiService(this);
        }
        return apiService;
    }

    public String getToken() {
        return token;
    }

    public Gson getGson() {
        return gson;
    }
}
