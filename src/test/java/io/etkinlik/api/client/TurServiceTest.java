package io.etkinlik.api.client;

import com.mashape.unirest.http.exceptions.UnirestException;
import io.etkinlik.api.client.model.Tur;
import io.etkinlik.api.client.model.request.EtkinlikListeConfig;
import io.etkinlik.api.client.model.response.EtkinlikListeResponse;
import org.junit.Test;

import java.util.Vector;

import static org.junit.Assert.assertEquals;

public class TurServiceTest {

    @Test
    public void testListe() throws UnirestException {

        ApiClient apiClient = new ApiClient("buraya-token-gelecek");

        Vector<Tur> turler = apiClient.getTurService().getListe();

        EtkinlikListeResponse etkinlikListeResponse = apiClient.getEtkinlikService().getListe(
                new EtkinlikListeConfig()
                        .setSayfa(1)
                        .setAdet(2)
        );

        assertEquals(21, turler.size());
        assertEquals(2, etkinlikListeResponse.getSayfalama().getAdet());
    }
}
