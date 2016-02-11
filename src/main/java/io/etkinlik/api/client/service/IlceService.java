package io.etkinlik.api.client.service;

import com.google.common.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.etkinlik.api.client.ApiClient;
import io.etkinlik.api.client.exception.BilinmeyenDurumException;
import io.etkinlik.api.client.exception.GenelHataException;
import io.etkinlik.api.client.exception.YetkilendirmeException;
import io.etkinlik.api.client.model.Ilce;
import io.etkinlik.api.client.model.response.exception.GenelHataResponse;
import io.etkinlik.api.client.model.response.exception.YetkilendirmeResponse;

import java.util.Vector;

public class IlceService {

    private final ApiClient client;

    public IlceService(ApiClient apiClient) {
        this.client = apiClient;
    }

    public Vector<Ilce> getListeBySehirId(int sehirId) throws
            UnirestException,
            GenelHataException,
            YetkilendirmeException,
            BilinmeyenDurumException {

        HttpResponse response = client.getApiService().get("/sehir/" + sehirId + "/ilceler");

        switch (response.getStatus()) {

            case 200:

                return client.getGson().fromJson(
                        response.getBody().toString(),
                        new TypeToken<Vector<Ilce>>(){}.getType()
                );

            case 400: throw new GenelHataException(client.getGson().fromJson(response.getBody().toString(), GenelHataResponse.class));
            case 401: throw new YetkilendirmeException(client.getGson().fromJson(response.getBody().toString(), YetkilendirmeResponse.class));
        }

        throw new BilinmeyenDurumException(response);
    }
}
