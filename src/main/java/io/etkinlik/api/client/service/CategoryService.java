package io.etkinlik.api.client.service;

import com.google.common.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.etkinlik.api.client.ApiClient;
import io.etkinlik.api.client.exception.UnauthorizedException;
import io.etkinlik.api.client.exception.UnknownException;
import io.etkinlik.api.client.model.Category;
import io.etkinlik.api.client.model.response.exception.UnauthorizedResponse;

import java.util.Vector;

public class CategoryService {

    private final ApiClient client;

    public CategoryService(ApiClient apiClient) {
        this.client = apiClient;
    }

    public Vector<Category> getItems() throws UnirestException {

        HttpResponse response = client.getApiService().get("/categories");

        switch (response.getStatus()) {

            case 200:

                return client.getGson().fromJson(
                        response.getBody().toString(),
                        new TypeToken<Vector<Category>>() {
                        }.getType()
                );

            case 401:
                throw new UnauthorizedException(client.getGson().fromJson(response.getBody().toString(), UnauthorizedResponse.class));
        }

        throw new UnknownException(response);
    }
}
