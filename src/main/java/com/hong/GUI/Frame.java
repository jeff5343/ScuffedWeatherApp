package com.hong.GUI;

import com.hong.Weather;
import com.hong.WeatherGrabber;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Frame extends JFrame
{

    private WeatherPane weatherPane;

    public Frame()
    {
        createComponents();

        this.setTitle("Weather");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
    }

    public void getScannerInput()
    {
        Scanner s = new Scanner(System.in);
        String city = s.nextLine();
        String country = s.nextLine();
        Weather w = new Weather(new WeatherGrabber().getJsonObject(city, country));
        weatherPane.showNewWeather(w);

        getScannerInput();
    }

    private void createComponents()
    {
        weatherPane = new WeatherPane();
        this.add(weatherPane);
        this.add(new InputPane(weatherPane), BorderLayout.PAGE_END);
    }

}
