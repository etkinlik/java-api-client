package io.etkinlik.api.client.service;

import com.google.common.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.etkinlik.api.client.ApiClient;
import io.etkinlik.api.client.exception.*;
import io.etkinlik.api.client.model.Event;
import io.etkinlik.api.client.model.request.EventsConfig;
import io.etkinlik.api.client.model.response.EventsResponse;
import io.etkinlik.api.client.model.response.exception.*;

public class EventService {
    private final ApiClient client;

    public EventService(ApiClient apiClient) {
        this.client = apiClient;
    }

    public EventsResponse getItems(EventsConfig config) throws
            UnirestException,
            UnauthorizedException,
            UnknownException {

        HttpResponse response = client.getApiService().get("/events", config.parameters());

        switch (response.getStatus()) {

            case 200:

                return client.getGson().fromJson(
                        response.getBody().toString(),
                        new TypeToken<EventsResponse>() {
                        }.getType()
                );

            case 401:
                throw new UnauthorizedException(client.getGson().fromJson(response.getBody().toString(), UnauthorizedResponse.class));
        }

        throw new UnknownException(response);
    }

    public Event getById(int id) throws
            UnirestException,
            MovedException,
            UnknownException,
            BadRequestException,
            NotFoundException {

        HttpResponse response = client.getApiService().get("/events/" + id);

        switch (response.getStatus()) {
            case 200:
                return client.getGson().fromJson(
                        response.getBody().toString(),
                        new TypeToken<Event>() {
                        }.getType()
                );
            case 301:
                throw new MovedException(client.getGson().fromJson(response.getBody().toString(), MovedResponse.class));
            case 400:
                throw new BadRequestException(client.getGson().fromJson(response.getBody().toString(), BadRequestResponse.class));
            case 401:
                throw new UnauthorizedException(client.getGson().fromJson(response.getBody().toString(), UnauthorizedResponse.class));
            case 404:
                throw new NotFoundException(client.getGson().fromJson(response.getBody().toString(), NotFoundResponse.class));
            case 410:
                throw new GoneException(client.getGson().fromJson(response.getBody().toString(), GoneResponse.class));
        }

        throw new UnknownException(response);
    }
}
