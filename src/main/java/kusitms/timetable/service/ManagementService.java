package kusitms.timetable.service;

import kusitms.timetable.domain.AvailableTime;
import kusitms.timetable.domain.Management;
import kusitms.timetable.dto.ManagementDto;
import kusitms.timetable.repository.AvailableTimeRepository;
import kusitms.timetable.repository.ManagementRepository;
import kusitms.timetable.util.TimeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ManagementService {
    private final ManagementRepository managementRepository;
    private final AvailableTimeRepository availableTimeRepository;
    private final TimeUtil timeUtil;

    public void addManagement(ManagementDto.addManagementRequest addManagementRequest) {
        String startTime = addManagementRequest.getStartTime().substring(1);
        String endTime = addManagementRequest.getEndTime().substring(1);
        String dayCode = addManagementRequest.getStartTime().substring(0, 1);

        List<String> timeIntervals = timeUtil.splitTimeIntervals(startTime, endTime, dayCode);
        Management management;
        Management existManagement = managementRepository.findByName(addManagementRequest.getName());
        if (existManagement == null) {
            management = Management.builder()
                    .name(addManagementRequest.getName())
                    .part(addManagementRequest.getPart())
                    .build();
            managementRepository.save(management);
        } else {
            management = existManagement;
        }

        List<AvailableTime> availableTimes = timeIntervals.stream()
                .map(timeInterval -> AvailableTime.builder()
                        .management(management)
                        .code(timeInterval)
                        .build())
                .collect(Collectors.toList());
        availableTimeRepository.saveAll(availableTimes);
    }
}