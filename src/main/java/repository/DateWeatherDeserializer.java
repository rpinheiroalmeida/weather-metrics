package repository;

import com.google.gson.*;

import java.lang.reflect.Type;

public class DateWeatherDeserializer implements JsonDeserializer<DateWeather> {

    @Override
    public DateWeather deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        return new DateWeather()
                .withDate(jsonObject.get("dt").getAsLong())
                .withDateFormatTxt(jsonObject.get("dt_txt").getAsString())
                .withTemperature(jsonObject.getAsJsonObject("main").get("temp").getAsDouble())
                .withPressure(jsonObject.getAsJsonObject("main").get("pressure").getAsDouble());
    }
}
