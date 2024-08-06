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
    public List<String> splitTimeIntervals(String startTime, String endTime, String dayCode) {
        List<String> timeIntervals = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        LocalTime start = LocalTime.parse(startTime, formatter);
        LocalTime end = LocalTime.parse(endTime, formatter);

        while (start.isBefore(end)) {
            timeIntervals.add(dayCode + start.format(formatter));
            start = start.plusMinutes(30);
        }

        return timeIntervals;
    }
}
