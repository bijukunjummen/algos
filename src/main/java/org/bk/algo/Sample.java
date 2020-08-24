package org.bk.algo;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Sample {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://builder.audiencemanager-dev.nike.com/consumer_behavior/audience_response/v1?filter=audienceId%2818a1c1c1-e6db-413a-9d74-2c2626f237d3%29&anchor=1000&fields=upmId%2C%20location_country%2C%20preferences_applanguage"))
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }
}
