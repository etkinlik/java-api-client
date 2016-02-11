package io.etkinlik.api.client.service;

import com.google.common.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.etkinlik.api.client.ApiClient;
import io.etkinlik.api.client.exception.BilinmeyenDurumException;
import io.etkinlik.api.client.exception.YetkilendirmeException;
import io.etkinlik.api.client.model.request.EtkinlikListeConfig;
import io.etkinlik.api.client.model.response.EtkinlikListeResponse;
import io.etkinlik.api.client.model.response.YetkilendirmeHatasiSonuc;

import java.util.Vector;

public class EtkinlikService {
    private final ApiClient client;

    public EtkinlikService(ApiClient apiClient) {
        this.client = apiClient;
    }

    public EtkinlikListeResponse getListe(EtkinlikListeConfig config) throws UnirestException {

        HttpResponse response = client.getApiService().get("/etkinlikler", config.parameters());

        switch (response.getStatus()) {

            case 200:

                return client.getGson().fromJson(
                        response.getBody().toString(),
                        new TypeToken<EtkinlikListeResponse>(){}.getType()
                );

            case 401: throw new YetkilendirmeException(client.getGson().fromJson(response.getBody().toString(), YetkilendirmeHatasiSonuc.class));
        }

        throw new BilinmeyenDurumException(response);
    }
}
