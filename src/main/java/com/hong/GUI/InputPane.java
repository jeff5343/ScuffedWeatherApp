package com.hong.GUI;

import com.hong.Weather;
import com.hong.WeatherGrabber;

import javax.swing.*;
import java.awt.*;

public class InputPane extends JPanel
{
    private final JTextField cityInput, countryInput;
    private final WeatherPane weatherPane;
    {
        cityInput=new JTextField();
        countryInput=new JTextField();
    }
    public InputPane(WeatherPane weatherPane)
    {
        createComponents();

        this.weatherPane = weatherPane;
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
        this.setPreferredSize(new Dimension(250, 50));
    }

    private void createComponents()
    {
        JButton submit = new JButton("OK");

        cityInput.setPreferredSize(new Dimension(75,30));
        countryInput.setPreferredSize(new Dimension(75,30));
        submit.setPreferredSize(new Dimension(50,30));
        submit.setFocusable(false);
        submit.addActionListener((e) -> {
            Weather weather = new Weather(new WeatherGrabber().getJsonObject(cityInput.getText(), countryInput.getText()));
            if(weather.getCity()==null)
            {
                System.out.println("invalid");
                return;
            }
            weatherPane.showNewWeather(weather);
            clearInputFields();
        });
        this.add(cityInput);
        this.add(countryInput);
        this.add(submit);
    }

    private void clearInputFields()
    {
        cityInput.setText("");
        countryInput.setText("");
    }
}
