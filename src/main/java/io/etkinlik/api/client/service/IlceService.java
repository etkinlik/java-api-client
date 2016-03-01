package io.etkinlik.api.client.service;

import com.google.common.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.etkinlik.api.client.ApiClient;
import io.etkinlik.api.client.exception.BadRequestException;
import io.etkinlik.api.client.exception.UnauthorizedException;
import io.etkinlik.api.client.exception.UnknownException;
import io.etkinlik.api.client.model.Ilce;
import io.etkinlik.api.client.model.response.exception.BadRequestResponse;
import io.etkinlik.api.client.model.response.exception.UnauthorizedResponse;

import java.util.Vector;

public class IlceService {

    private final ApiClient client;

    public IlceService(ApiClient apiClient) {
        this.client = apiClient;
    }

    public Vector<Ilce> getListeBySehirId(int sehirId) throws
            UnirestException,
            BadRequestException,
            UnauthorizedException,
            UnknownException {

        HttpResponse response = client.getApiService().get("/sehir/" + sehirId + "/ilceler");

        switch (response.getStatus()) {

            case 200:

                return client.getGson().fromJson(
                        response.getBody().toString(),
                        new TypeToken<Vector<Ilce>>(){}.getType()
                );

            case 400: throw new BadRequestException(client.getGson().fromJson(response.getBody().toString(), BadRequestResponse.class));
            case 401: throw new UnauthorizedException(client.getGson().fromJson(response.getBody().toString(), UnauthorizedResponse.class));
        }

        throw new UnknownException(response);
    }
}
