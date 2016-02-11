package io.etkinlik.api.client.service;

import com.google.common.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.etkinlik.api.client.ApiClient;
import io.etkinlik.api.client.exception.BilinmeyenDurumException;
import io.etkinlik.api.client.exception.YetkilendirmeException;
import io.etkinlik.api.client.model.Sehir;
import io.etkinlik.api.client.model.response.exception.YetkilendirmeResponse;

import java.util.Vector;

public class SehirService {

    private final ApiClient client;

    public SehirService(ApiClient apiClient) {
        this.client = apiClient;
    }

    public Vector<Sehir> getListe() throws UnirestException {

        HttpResponse response = client.getApiService().get("/kategoriler");

        switch (response.getStatus()) {

            case 200:

                return client.getGson().fromJson(
                        response.getBody().toString(),
                        new TypeToken<Vector<Sehir>>(){}.getType()
                );

            case 401: throw new YetkilendirmeException(client.getGson().fromJson(response.getBody().toString(), YetkilendirmeResponse.class));
        }

        throw new BilinmeyenDurumException(response);
    }
}