package io.etkinlik.api.client.service;

import com.google.common.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.etkinlik.api.client.ApiClient;
import io.etkinlik.api.client.exception.*;
import io.etkinlik.api.client.model.Etkinlik;
import io.etkinlik.api.client.model.request.EtkinlikListeConfig;
import io.etkinlik.api.client.model.response.EtkinlikListeResponse;
import io.etkinlik.api.client.model.response.exception.BulunamadiResponse;
import io.etkinlik.api.client.model.response.exception.GenelHataResponse;
import io.etkinlik.api.client.model.response.exception.MukerrerResponse;
import io.etkinlik.api.client.model.response.exception.YetkilendirmeResponse;

public class EtkinlikService {
    private final ApiClient client;

    public EtkinlikService(ApiClient apiClient) {
        this.client = apiClient;
    }

    public EtkinlikListeResponse getListe(EtkinlikListeConfig config) throws
            UnirestException,
            YetkilendirmeException,
            BilinmeyenDurumException {

        HttpResponse response = client.getApiService().get("/etkinlikler", config.parameters());

        switch (response.getStatus()) {

            case 200:

                return client.getGson().fromJson(
                        response.getBody().toString(),
                        new TypeToken<EtkinlikListeResponse>(){}.getType()
                );

            case 401: throw new YetkilendirmeException(client.getGson().fromJson(response.getBody().toString(), YetkilendirmeResponse.class));
        }

        throw new BilinmeyenDurumException(response);
    }

    public Etkinlik getById(int etkinlikId) throws
            UnirestException,
            MukerrerException,
            BilinmeyenDurumException,
            GenelHataException,
            BulunamadiException {

        HttpResponse response = client.getApiService().get("/etkinlik/" + etkinlikId);

        switch (response.getStatus()) {
            case 200:
                return client.getGson().fromJson(
                        response.getBody().toString(),
                        new TypeToken<Etkinlik>(){}.getType()
                );
            case 301: throw new MukerrerException(client.getGson().fromJson(response.getBody().toString(), MukerrerResponse.class));
            case 400: throw new GenelHataException(client.getGson().fromJson(response.getBody().toString(), GenelHataResponse.class));
            case 401: throw new YetkilendirmeException(client.getGson().fromJson(response.getBody().toString(), YetkilendirmeResponse.class));
            case 404: throw new BulunamadiException(client.getGson().fromJson(response.getBody().toString(), BulunamadiResponse.class));
        }

        throw new BilinmeyenDurumException(response);
    }
}
