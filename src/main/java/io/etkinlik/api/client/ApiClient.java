package io.etkinlik.api.client;

import com.google.gson.Gson;
import io.etkinlik.api.client.service.ApiService;
import io.etkinlik.api.client.service.EtkinlikService;
import io.etkinlik.api.client.service.TurService;

public class ApiClient {

    private String token;
    private Gson gson;

    private static EtkinlikService etkinlikService = null;
    private static ApiService apiService = null;
    private static TurService turService = null;


    public ApiClient(String token) {
        this.token = token;
        gson = new Gson();
    }

    public EtkinlikService getEtkinlikService() {
        if (etkinlikService == null) {
            etkinlikService = new EtkinlikService(this);
        }
        return etkinlikService;
    }

    public TurService getTurService() {
        if (turService == null) {
            turService = new TurService(this);
        }
        return turService;
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
