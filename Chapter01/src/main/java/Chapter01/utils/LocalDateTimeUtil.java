package Chapter01.utils;

import org.apache.commons.lang3.StringUtils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public final class LocalDateTimeUtil {
    private LocalDateTimeUtil() {
    }

    private static final DateTimeFormatter DEFAULT_FORMATTER
            = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static long localDateTime2Stamp(LocalDateTime now) {
        return Objects.requireNonNullElseGet(now, LocalDateTime::now).toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }

    public static String timestamp2String(long timestamp, String format) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneOffset.of("+8"));
        if (StringUtils.isNotBlank(format)) {
            return DateTimeFormatter.ofPattern(format).format(localDateTime);
        }
        return DEFAULT_FORMATTER.format(localDateTime);
    }

    public static void main(String[] args) {
        System.out.println(LocalDateTime.now());
        System.out.println(localDateTime2Stamp(null));
        System.out.println(timestamp2String(1659280102392L, null));
    }
}
