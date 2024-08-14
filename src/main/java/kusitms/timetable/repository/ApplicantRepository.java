package kusitms.timetable.repository;

import kusitms.timetable.domain.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
    Applicant findByNameAndPart(String name, String part);
}