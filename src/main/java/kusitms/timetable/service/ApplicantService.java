package kusitms.timetable.service;

import kusitms.timetable.domain.Applicant;
import kusitms.timetable.domain.AvailableTime;
import kusitms.timetable.dto.ApplicantDto;
import kusitms.timetable.repository.ApplicantRepository;
import kusitms.timetable.repository.AvailableTimeRepository;
import kusitms.timetable.util.TimeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApplicantService {
    private final ApplicantRepository applicantRepository;
    private final AvailableTimeRepository availableTimeRepository;
    private final TimeUtil timeUtil;

    public void addApplicant(ApplicantDto.addApplicantRequest addApplicantRequest) {
        String startTime = addApplicantRequest.getStartTime().substring(1);
        String endTime = addApplicantRequest.getEndTime().substring(1);
        String dayCode = addApplicantRequest.getStartTime().substring(0, 1);

        List<String> timeIntervals = timeUtil.splitTimeIntervals(startTime, endTime, dayCode);

        Applicant applicant = Applicant.builder()
                .name(addApplicantRequest.getName())
                .part(addApplicantRequest.getPart())
                .build();
        applicantRepository.save(applicant);

        List<AvailableTime> availableTimes = timeIntervals.stream()
                .map(timeInterval -> AvailableTime.builder()
                        .applicant(applicant)
                        .code(timeInterval)
                        .build())
                .collect(Collectors.toList());
        availableTimeRepository.saveAll(availableTimes);
    }
}