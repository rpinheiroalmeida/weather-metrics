package presentation;


import com.google.gson.annotations.SerializedName;

public class WeatherView {

    @SerializedName("average_daily")
    private double averageDaily;
    @SerializedName("average_nightly")
    private double averageNightly;
    @SerializedName("average_pressure")
    private double averagePressure;

    public WeatherView(double averageDaily, double averageNightly, double averagePressure) {
        this.averageDaily = averageDaily;
        this.averageNightly = averageNightly;
        this.averagePressure = averagePressure;
    }

    public static WeatherView of(AverageWeather averageWeather) {
        return new WeatherView(averageWeather.getDaily(),
                averageWeather.getNightly(),
                averageWeather.getPressure());
    }
}
