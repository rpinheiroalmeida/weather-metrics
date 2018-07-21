package util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class DateUtil {

    private static final int NEXT_DAY_TO_FILTER = 3;

    public static boolean isInTheNextThreeDays(long startDate, long endDate) {
        LocalDateTime ldt = LocalDateTime.ofInstant(Instant.ofEpochSecond(endDate), ZoneOffset.UTC);
        LocalDateTime ldtStart = LocalDateTime.ofInstant(Instant.ofEpochSecond(startDate), ZoneOffset.UTC);
        return ldtStart.getDayOfMonth() + NEXT_DAY_TO_FILTER >= ldt.getDayOfMonth() ;
    }
}
