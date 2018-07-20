package model;

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
}
