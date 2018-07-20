package repository;

import com.google.gson.annotations.JsonAdapter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@JsonAdapter(DateWeatherDeserializer.class)
public class ListDataWeather {

    private long date;

    private double temperature;

    private double pressure;

    private String dateFormatTxt;

    public ListDataWeather withDate(long date) {
        this.date = date;
        return this;
    }

    public ListDataWeather withTemperature(double temperature) {
        this.temperature = temperature;
        return this;
    }

    public ListDataWeather withPressure(double pressure) {
        this.pressure = pressure;
        return this;
    }

    public ListDataWeather withDateFormatTxt(String dateFormatTxt) {
        this.dateFormatTxt = dateFormatTxt;
        return this;
    }

    @Override
    public String toString() {
        return "ListDataWeather{" +
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

        ListDataWeather that = (ListDataWeather) o;

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

    public double getPressure() {
        return pressure;
    }

    public double getTemperature() {
        return temperature;
    }

    public boolean isDailyTemperature() {
        LocalDateTime ldt = LocalDateTime.ofInstant(Instant.ofEpochSecond(date), ZoneOffset.UTC);
        return ldt.getHour() >= 6 && ldt.getHour() <= 18;
    }

    public boolean isNightlyTemperature() {
        return !isDailyTemperature();
    }
}
