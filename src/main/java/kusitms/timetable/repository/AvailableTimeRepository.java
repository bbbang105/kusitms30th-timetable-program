package kusitms.timetable.repository;

import kusitms.timetable.domain.Applicant;
import kusitms.timetable.domain.AvailableTime;
import kusitms.timetable.domain.Management;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvailableTimeRepository extends JpaRepository<AvailableTime, Long> {
    List<AvailableTime> findAllByApplicant(Applicant applicant);
    AvailableTime findByManagementAndCode(Management management, String code);
}