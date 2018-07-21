package presentation;


import com.google.gson.annotations.SerializedName;

public class WeatherView {

    @SerializedName("average_daily")
    private double averageDaily;
    @SerializedName("average_nightly")
    private double averageNightly;
    @SerializedName("average_pressure")
    private double averagePressure;
    @SerializedName("city")
    private String city;

    public static final WeatherView NULL = new WeatherView(0.0, 0.0, 0.0, "");

    public WeatherView(double averageDaily, double averageNightly, double averagePressure, String city) {
        this.averageDaily = averageDaily;
        this.averageNightly = averageNightly;
        this.averagePressure = averagePressure;
        this.city = city;
    }

}
