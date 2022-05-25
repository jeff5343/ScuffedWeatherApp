package com.hong.GUI;

import com.hong.Weather;
import com.hong.WeatherGrabber;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class WeatherPane extends JPanel
{

    private JPanel main;
    private Weather weather;
    private final JLabel[] labels;
    private final DecimalFormat df;
    {
        WeatherGrabber grabber = new WeatherGrabber();
        weather = new Weather(grabber.getJsonObject("Cerritos", "US"));

        labels = new JLabel[5];
        df = new DecimalFormat("0.00");
    }

    public WeatherPane()
    {
        createComponents();

        this.setLayout(null);
        this.setPreferredSize(new Dimension(250, 175));
    }

    public void showNewWeather(Weather weather)
    {
        this.weather = weather;
        this.remove(main);
        createComponents();
        revalidate();
        repaint();
    }

    private void createComponents()
    {
        main = new JPanel();
        main.setBounds(44, 40, 165, 175);
        main.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 3));
        setUpLabels();
        for(JLabel label : labels)
        {
            main.add(label);
        }
        this.add(main);
    }

    private void setUpLabels()
    {
        labels[0] = new JLabel(weather.getCity() + ", " + weather.getCountry(), JLabel.CENTER);
        labels[1] = new JLabel("Temperature: " + df.format(weather.getTemp()) + "℉", JLabel.CENTER);
        labels[2] = new JLabel("HIGH: " + df.format(weather.getTempHi()), JLabel.CENTER);
        labels[3] = new JLabel("LOW: " + df.format(weather.getTempLo()), JLabel.CENTER);
        labels[4] = new JLabel("Weather: " + weather.getDescription(), JLabel.CENTER);

        labels[0].setFont(new Font("Roboto", Font.BOLD, 20));
    }

}
