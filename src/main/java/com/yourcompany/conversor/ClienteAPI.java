package com.yourcompany.conversor;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

public class ClienteAPI {
    private static final String API_KEY = "10dac06dfb5aea8228357370";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY;

    public static double getTasaConversion(String monedaOrigen, String monedaDestino) throws IOException {
        OkHttpClient client = new OkHttpClient();
        String url = BASE_URL + "/pair/" + monedaOrigen + "/" + monedaDestino;
        Request request = new Request.Builder().url(url).build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Error en la API: " + response);

            String jsonData = response.body().string();
            JsonObject jsonObject = JsonParser.parseString(jsonData).getAsJsonObject();
            return jsonObject.get("conversion_rate").getAsDouble();
        }
    }
}