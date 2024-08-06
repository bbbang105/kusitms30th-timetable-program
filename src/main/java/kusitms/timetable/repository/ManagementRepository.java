package kusitms.timetable.repository;

import kusitms.timetable.domain.Management;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagementRepository extends JpaRepository<Management, Long> {
}