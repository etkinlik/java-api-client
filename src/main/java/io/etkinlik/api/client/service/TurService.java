package io.etkinlik.api.client.service;

import com.google.common.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.etkinlik.api.client.ApiClient;
import io.etkinlik.api.client.exception.BilinmeyenDurumException;
import io.etkinlik.api.client.exception.YetkilendirmeException;
import io.etkinlik.api.client.model.Tur;
import io.etkinlik.api.client.model.response.YetkilendirmeHatasiSonuc;

import java.util.Vector;
import java.util.concurrent.ExecutionException;

public class TurService {

    private final ApiClient client;

    public TurService(ApiClient apiClient) {
        this.client = apiClient;
    }

    public Vector<Tur> getListe() throws UnirestException {

        HttpResponse response = client.getApiService().get("/turler");

        switch (response.getStatus()) {

            case 200:

                return client.getGson().fromJson(
                        response.getBody().toString(),
                        new TypeToken<Vector<Tur>>(){}.getType()
                );

            case 401: throw new YetkilendirmeException(client.getGson().fromJson(response.getBody().toString(), YetkilendirmeHatasiSonuc.class));
        }

        throw new BilinmeyenDurumException(response);
    }
}
