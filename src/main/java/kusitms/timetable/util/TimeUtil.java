package kusitms.timetable.util;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class TimeUtil {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    public List<String> splitTimeIntervals(String startTime, String endTime, String dayCode) {
        List<String> timeIntervals = new ArrayList<>();

        LocalTime start = LocalTime.parse(startTime, FORMATTER);
        LocalTime end = LocalTime.parse(endTime, FORMATTER);

        while (start.isBefore(end)) {
            timeIntervals.add(dayCode + start.format(FORMATTER));
            start = start.plusMinutes(30);
        }

        return timeIntervals;
    }

    public String minusThirtyMinutes(String code) {
        String dayCode = code.substring(0, 1);
        String timePart = code.substring(1);

        LocalTime time = LocalTime.parse(timePart, FORMATTER);
        LocalTime previousTime = time.minusMinutes(30);

        return dayCode + previousTime.format(FORMATTER);
    }
}