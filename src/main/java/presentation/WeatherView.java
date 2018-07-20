package presentation;


import com.google.gson.annotations.SerializedName;

public class WeatherView {

    @SerializedName("average_daily")
    private String averageDaily;
    @SerializedName("average_nightly")
    private String averageNightly;
    @SerializedName("average_pressure")
    private String averagePressure;

    public WeatherView(String averageDaily, String averageNightly, String averagePressure) {
        this.averageDaily = averageDaily;
        this.averageNightly = averageNightly;
        this.averagePressure = averagePressure;
    }

    public String getAverageDaily() {
        return averageDaily;
    }

    public void setAverageDaily(String averageDaily) {
        this.averageDaily = averageDaily;
    }

    public String getAverageNightly() {
        return averageNightly;
    }

    public void setAverageNightly(String averageNightly) {
        this.averageNightly = averageNightly;
    }

    public String getAveragePressure() {
        return averagePressure;
    }

    public void setAveragePressure(String averagePressure) {
        this.averagePressure = averagePressure;
    }
}
