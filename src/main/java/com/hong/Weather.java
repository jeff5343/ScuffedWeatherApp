package com.hong;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Weather
{
    private String city, country;
    private double temp, tempHi, tempLo;
    private String description;

    public Weather(JsonObject object)
    {
        JsonObject main = object.getAsJsonObject("main");
        if(main==null) return;
        temp = kelvinToFahrenheit(main.get("temp").getAsDouble());
        tempHi = kelvinToFahrenheit(main.get("temp_max").getAsDouble());
        tempLo = kelvinToFahrenheit(main.get("temp_min").getAsDouble());

        JsonArray weather = object.getAsJsonArray("weather");
        description = weather.get(0).getAsJsonObject().get("description").getAsString();

        JsonObject sys = object.getAsJsonObject("sys");
        city = object.get("name").getAsString();
        country = sys.get("country").getAsString();
    }

    private double kelvinToFahrenheit(double kelvin)
    {
        return ((kelvin-273.15)*9)/5 + 32;
    }

    @Override
    public String toString()
    {
        return "[city: " + city + ", country: " + country +
                ",\n temp: " + temp + ", tempLo: " + tempLo + ", tempHi: " + tempHi +
                "\n description: " + description;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public double getTemp() {
        return temp;
    }

    public double getTempHi() {
        return tempHi;
    }

    public double getTempLo() {
        return tempLo;
    }

    public String getDescription() {
        return description;
    }
}
