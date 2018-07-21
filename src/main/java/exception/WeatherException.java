package exception;


public class WeatherException extends Throwable {

    private int status;

    public WeatherException(String message, int status) {
        super(message);
        this.status = status;
    }
}
