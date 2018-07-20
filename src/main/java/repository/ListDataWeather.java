package repository;

import com.google.gson.annotations.SerializedName;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class ListDataWeather {

    public double getTemperature() {
        return mainDataWeather.temperature;
    }

    public double getPressure() {
        return mainDataWeather.pressure;
    }

    public long getDate() {
        return date;
    }

    public static class MainDataWeather {
        @SerializedName("temp")
        private double temperature;

        @SerializedName("pressure")
        private double pressure;

        public MainDataWeather(double temperature, double pressure) {
            this.temperature = temperature;
            this.pressure = pressure;
        }

        @Override
        public String toString() {
            return "MainDataWeather{" +
                    "temperature=" + temperature +
                    ", pressure=" + pressure +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            MainDataWeather that = (MainDataWeather) o;

            if (Double.compare(that.temperature, temperature) != 0) return false;
            return Double.compare(that.pressure, pressure) == 0;

        }

        @Override
        public int hashCode() {
            int result;
            long temp;
            temp = Double.doubleToLongBits(temperature);
            result = (int) (temp ^ (temp >>> 32));
            temp = Double.doubleToLongBits(pressure);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            return result;
        }
    }

    @SerializedName("dt")
    private long date;

    @SerializedName("main")
    private MainDataWeather mainDataWeather;

    @SerializedName("dt_txt")
    private String dateFormatTxt;

    public ListDataWeather withDate(long date) {
        this.date = date;
        return this;
    }

    public ListDataWeather withMainDataWeather(MainDataWeather mainDataWeather) {
        this.mainDataWeather = mainDataWeather;
        return this;
    }

    public ListDataWeather withDateFormatTxt(String dateFormatTxt) {
        this.dateFormatTxt = dateFormatTxt;
        return this;
    }

    public boolean isDailyTemperature() {
        LocalDateTime ldt = LocalDateTime.ofInstant(Instant.ofEpochSecond(date), ZoneOffset.UTC);
        return ldt.getHour() >= 6 && ldt.getHour() <= 18;
    }

    public boolean isNightlyTemperature() {
        return !isDailyTemperature();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListDataWeather that = (ListDataWeather) o;

        if (date != that.date) return false;
        if (mainDataWeather != null ? !mainDataWeather.equals(that.mainDataWeather) : that.mainDataWeather != null)
            return false;
        return dateFormatTxt != null ? dateFormatTxt.equals(that.dateFormatTxt) : that.dateFormatTxt == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (date ^ (date >>> 32));
        result = 31 * result + (mainDataWeather != null ? mainDataWeather.hashCode() : 0);
        result = 31 * result + (dateFormatTxt != null ? dateFormatTxt.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ListDataWeather{" +
                "date=" + date +
                ", mainDataWeather=" + mainDataWeather +
                ", dateFormatTxt='" + dateFormatTxt + '\'' +
                '}';
    }
}
