package repository;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

@JsonAdapter(DateWeatherDeserializer.class)
public class DateWeather {

    @SerializedName("dt")
    private long date;

    @SerializedName("temp")
    private double temperature;

    @SerializedName("$.main[0].pressure")
    private double pressure;

    @SerializedName("dt_txt")
    private String dateFormatTxt;

    public DateWeather withDate(long date) {
        this.date = date;
        return this;
    }

    public DateWeather withTemperature(double temperature) {
        this.temperature = temperature;
        return this;
    }

    public DateWeather withPressure(double pressure) {
        this.pressure = pressure;
        return this;
    }

    public DateWeather withDateFormatTxt(String dateFormatTxt) {
        this.dateFormatTxt = dateFormatTxt;
        return this;
    }

    @Override
    public String toString() {
        return "DateWeather{" +
                "date=" + date +
                ", temperature=" + temperature +
                ", pressure=" + pressure +
                ", dateFormatTxt='" + dateFormatTxt + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DateWeather that = (DateWeather) o;

        if (date != that.date) return false;
        if (Double.compare(that.temperature, temperature) != 0) return false;
        if (Double.compare(that.pressure, pressure) != 0) return false;
        return dateFormatTxt != null ? dateFormatTxt.equals(that.dateFormatTxt) : that.dateFormatTxt == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (date ^ (date >>> 32));
        temp = Double.doubleToLongBits(temperature);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(pressure);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (dateFormatTxt != null ? dateFormatTxt.hashCode() : 0);
        return result;
    }
}
