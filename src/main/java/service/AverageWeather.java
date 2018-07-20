package service;


public class AverageWeather {

    private final double daily;
    private final double nightly;
    private final double pressure;

    public AverageWeather(double daily, double nightly, double pressure) {
        this.daily = daily;
        this.nightly = nightly;
        this.pressure = pressure;
    }

    @Override
    public String toString() {
        return "AverageWeather{" +
                "daily=" + daily +
                ", nightly=" + nightly +
                ", pressure=" + pressure +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AverageWeather that = (AverageWeather) o;

        if (Double.compare(that.daily, daily) != 0) return false;
        if (Double.compare(that.nightly, nightly) != 0) return false;
        return Double.compare(that.pressure, pressure) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(daily);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(nightly);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(pressure);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public double getDaily() {
        return daily;
    }

    public double getNightly() {
        return nightly;
    }

    public double getPressure() {
        return pressure;
    }
}
