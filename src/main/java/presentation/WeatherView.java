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

    @Override
    public String toString() {
        return "WeatherView{" +
                "averageDaily=" + averageDaily +
                ", averageNightly=" + averageNightly +
                ", averagePressure=" + averagePressure +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeatherView that = (WeatherView) o;

        if (Double.compare(that.averageDaily, averageDaily) != 0) return false;
        if (Double.compare(that.averageNightly, averageNightly) != 0) return false;
        if (Double.compare(that.averagePressure, averagePressure) != 0) return false;
        return city != null ? city.equals(that.city) : that.city == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(averageDaily);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(averageNightly);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(averagePressure);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }
}
