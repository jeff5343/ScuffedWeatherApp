package com.hong;

import com.google.gson.*;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

import java.net.URLEncoder;

public class WeatherGrabber
{

    private final String host = "https://community-open-weather-map.p.rapidapi.com/weather";
    private final String charset = "UTF-8";
    private final String x_rapidapi_host = "community-open-weather-map.p.rapidapi.com";
    private final String x_rapidapi_key = "ec7618994dmsh5d644c2466bfc66p1addd2jsnac2d76d8a135";
    private String q;
    private String query;

    public JsonObject getJsonObject(String city, String country)
    {
        try {
            q = city+","+country;
            query = String.format("q=%s", URLEncoder.encode(q, charset));
            HttpResponse<JsonNode> response = Unirest.get(host + "?" + query)
                    .header("X-RapidAPI-Host", x_rapidapi_host)
                    .header("X-RapidAPI-Key", x_rapidapi_key)
                    .asJson();
            JsonParser jp = new JsonParser();
            return jp.parse(response.getBody().toString()).getAsJsonObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
