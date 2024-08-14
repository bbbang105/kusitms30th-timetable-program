package kusitms.timetable.repository;

import kusitms.timetable.domain.TimeTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimeTableRepository extends JpaRepository<TimeTable, Long> {
    TimeTable findByCode(String code);
    List<TimeTable> findAllByCode(String code);
}