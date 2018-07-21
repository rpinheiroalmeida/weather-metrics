package http;


import org.apache.http.client.fluent.Request;

import java.io.IOException;
import java.net.URLEncoder;


public class HttpOpenWeatherRequest {

    private static final String URL_OPEN_WEATHER_MAP = "http://api.openweathermap.org/data/2.5/forecast?q=%s&appid=%s";

    public String getResponseContent(String city) throws IOException {
        return Request.Get(
                String.format(URL_OPEN_WEATHER_MAP,
                        URLEncoder.encode(city, "UTF-8"), System.getProperty("api.key")/*"b79bfe9da8b1e51883b30b37fa7460e8"*/))
                            .execute()
                            .returnContent()
                .asString();
    }
}
