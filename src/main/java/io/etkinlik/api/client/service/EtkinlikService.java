package io.etkinlik.api.client.service;

import com.google.common.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.etkinlik.api.client.ApiClient;
import io.etkinlik.api.client.exception.*;
import io.etkinlik.api.client.model.Etkinlik;
import io.etkinlik.api.client.model.request.EtkinlikListeConfig;
import io.etkinlik.api.client.model.response.EtkinlikListeResponse;
import io.etkinlik.api.client.model.response.exception.*;

public class EtkinlikService {
    private final ApiClient client;

    public EtkinlikService(ApiClient apiClient) {
        this.client = apiClient;
    }

    public EtkinlikListeResponse getListe(EtkinlikListeConfig config) throws
            UnirestException,
            UnauthorizedException,
            UnknownException {

        HttpResponse response = client.getApiService().get("/etkinlikler", config.parameters());

        switch (response.getStatus()) {

            case 200:

                return client.getGson().fromJson(
                        response.getBody().toString(),
                        new TypeToken<EtkinlikListeResponse>(){}.getType()
                );

            case 401: throw new UnauthorizedException(client.getGson().fromJson(response.getBody().toString(), UnauthorizedResponse.class));
        }

        throw new UnknownException(response);
    }

    public Etkinlik getById(int etkinlikId) throws
            UnirestException,
            MovedException,
            UnknownException,
            BadRequestException,
            NotFoundException {

        HttpResponse response = client.getApiService().get("/etkinlik/" + etkinlikId);

        switch (response.getStatus()) {
            case 200:
                return client.getGson().fromJson(
                        response.getBody().toString(),
                        new TypeToken<Etkinlik>(){}.getType()
                );
            case 301: throw new MovedException(client.getGson().fromJson(response.getBody().toString(), MovedResponse.class));
            case 400: throw new BadRequestException(client.getGson().fromJson(response.getBody().toString(), BadRequestResponse.class));
            case 401: throw new UnauthorizedException(client.getGson().fromJson(response.getBody().toString(), UnauthorizedResponse.class));
            case 404: throw new NotFoundException(client.getGson().fromJson(response.getBody().toString(), NotFoundResponse.class));
            case 410: throw new GoneException(client.getGson().fromJson(response.getBody().toString(), GoneResponse.class));
        }

        throw new UnknownException(response);
    }
}
