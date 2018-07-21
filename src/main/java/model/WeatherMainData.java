package model;

import repository.ListDataWeather;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class WeatherMainData {
    private double temperature;
    private double pressure;
    private long date;

    public WeatherMainData(double temperature, double pressure, long date) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.date = date;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getPressure() {
        return pressure;
    }

    public boolean isNightlyTemperature() {
        return !isDailyTemperature();
    }

    public boolean isDailyTemperature() {
        LocalDateTime ldt = LocalDateTime.ofInstant(Instant.ofEpochSecond(date), ZoneOffset.UTC);
        return ldt.getHour() >= 6 && ldt.getHour() <= 18;
    }

}
