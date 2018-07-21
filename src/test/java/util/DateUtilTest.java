package util;

import model.ForecastWeather;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.time.Instant;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;


public class DateUtilTest {
    @Test
    public void theDataIsInTheNextThreeDays() {
        System.out.println(Instant.now().getEpochSecond());
        assertThat(DateUtil.isInTheNextThreeDays(1532206800, 1532206800), Matchers.is(true));
        assertThat(DateUtil.isInTheNextThreeDays(1532206800, 1532131200), Matchers.is(true));
        assertThat(DateUtil.isInTheNextThreeDays(1532206800, 1532217600), Matchers.is(true));
        assertThat(DateUtil.isInTheNextThreeDays(1532206800, 1532304000), Matchers.is(true));
    }

    @Test
    public void theDataIsNotInTheNextThreeDays() {
        assertThat(DateUtil.isInTheNextThreeDays(1532120400, 1532412000), Matchers.is(false));
        assertThat(DateUtil.isInTheNextThreeDays(1532120400, 1532509200), Matchers.is(false));

    }
}