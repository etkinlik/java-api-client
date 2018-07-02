package io.etkinlik.api.client;

import com.mashape.unirest.http.exceptions.UnirestException;
import io.etkinlik.api.client.model.Format;
import io.etkinlik.api.client.model.request.EventsConfig;
import io.etkinlik.api.client.model.response.EventsResponse;
import org.junit.jupiter.api.Test;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FormatServiceTest {

    @Test
    public void testListe() throws UnirestException {

        ApiClient apiClient = new ApiClient("buraya token gelecek");

        Vector<Format> turler = apiClient.getFormatService().getItems();

        EventsResponse etkinlikListeResponse = apiClient.getEventService().getItems(
                new EventsConfig()
                        .setSkip(1)
                        .setTake(2)
        );

        assertEquals(22, turler.size());
        assertEquals(1202, etkinlikListeResponse.getMeta().getTotalCount());
    }
}
