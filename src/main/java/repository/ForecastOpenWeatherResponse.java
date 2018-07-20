package repository;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ForecastOpenWeatherResponse {

    @SerializedName("cod")
    private int statusResponse;

    @SerializedName("cnt")
    private int quantityDays;

    private City city;

    @SerializedName("list")
    private List<ListDataWeather> dataWather = new ArrayList<>();

    private String message;
    private String status;

    public ForecastOpenWeatherResponse withCode(int code) {
        this.statusResponse = code;
        return this;
    }

    public ForecastOpenWeatherResponse withNumberLines(int numberLines) {
        this.quantityDays = numberLines;
        return this;
    }

    public ForecastOpenWeatherResponse withCity(City city) {
        this.city = city;
        return this;
    }

    public ForecastOpenWeatherResponse add(ListDataWeather listDataWeather) {
        this.dataWather.add(listDataWeather);
        return this;
    }

    public ForecastOpenWeatherResponse withMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public String toString() {
        return "ForecastOpenWeatherResponse{" +
                "statusResponse=" + statusResponse +
                ", quantityDays=" + quantityDays +
                ", city=" + city +
                ", dataWather=" + dataWather +
                ", message='" + message + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ForecastOpenWeatherResponse that = (ForecastOpenWeatherResponse) o;

        if (statusResponse != that.statusResponse) return false;
        if (quantityDays != that.quantityDays) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (dataWather != null ? !dataWather.equals(that.dataWather) : that.dataWather != null) return false;
        return message != null ? message.equals(that.message) : that.message == null;
    }

    @Override
    public int hashCode() {
        int result = statusResponse;
        result = 31 * result + quantityDays;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (dataWather != null ? dataWather.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }

    public int getStatusResponse() {
        return statusResponse;
    }

    public City getCity() {
        return city;
    }

    public List<ListDataWeather> getDataWeather() {
        return dataWather;
    }
}
