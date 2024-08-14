package kusitms.timetable.service;

import kusitms.timetable.domain.Applicant;
import kusitms.timetable.domain.AvailableTime;
import kusitms.timetable.domain.Management;
import kusitms.timetable.domain.TimeTable;
import kusitms.timetable.repository.ApplicantRepository;
import kusitms.timetable.repository.AvailableTimeRepository;
import kusitms.timetable.repository.ManagementRepository;
import kusitms.timetable.repository.TimeTableRepository;
import kusitms.timetable.util.TimeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProgramService {
    private final ApplicantRepository applicantRepository;
    private final ManagementRepository managementRepository;
    private final AvailableTimeRepository availableTimeRepository;
    private final TimeTableRepository timeTableRepository;
    private final TimeUtil timeUtil;

    public void runAutoArrangementProgram() {
        List<Applicant> applicants = applicantRepository.findAll();

        for (Applicant applicant : applicants) {
            List<AvailableTime> availableTimes = availableTimeRepository.findAllByApplicant(applicant);
            List<Management> managements = managementRepository.findAll();

            for (AvailableTime availableTime : availableTimes) {
                String code = availableTime.getCode();
                String previousTimeCode = "";
                if (!code.equals("T10:00") && !code.equals("S10:00")) {
                    previousTimeCode = timeUtil.minusThirtyMinutes(code);
                }

                List<Management> availableManagements = new ArrayList<>();
                List<Management> availableGuides = new ArrayList<>();

                for (Management management : managements) {
                    List<TimeTable> existTimeTables = timeTableRepository.findAllByCode(previousTimeCode);
                    boolean isInterviewAvailable = true;

                    for (TimeTable timeTable : existTimeTables) {
                        if ((timeTable.getManagementOne() != null && timeTable.getManagementOne().equals(management.getName()))
                                || ((timeTable.getManagementTwo() != null && timeTable.getManagementTwo().equals(management.getName())))) {
                            isInterviewAvailable = false;
                            break;
                        }
                    }

                    AvailableTime managementTime = availableTimeRepository.findByManagementAndCode(management, code);
                    if (managementTime == null || managementTime.getIsArrange()) {
                        continue;
                    }

                    if (isInterviewAvailable && applicant.getPart().equals(management.getPart())) {
                        availableManagements.add(management);
                    }

                    availableGuides.add(management);
                }

                boolean isFixed = false;
                if (!availableManagements.isEmpty()) {
                    for (Management availableManagement : availableManagements) {
                        List<TimeTable> timeTables = timeTableRepository.findAllByCode(code);

                        for (int i = 0; i < timeTables.size(); i++) {
                            TimeTable timeTable = timeTables.get(i);

                            if (timeTable.getPart() != null && !timeTable.getPart().equals(availableManagement.getPart())) {
                                continue;
                            }

                            if (timeTable.getApplicantOne() == null) {
                                if (i == 1 && timeTables.get(0).getManagementOne().equals(availableManagement.getName())) {
                                    continue;
                                }

                                applicant.arrange();
                                applicantRepository.save(applicant);
                                availableManagement.increaseInterviewCount();
                                managementRepository.save(availableManagement);
                                timeTable.addApplicantOne(applicant.getName());
                                timeTable.addManagementOne(availableManagement.getName());
                                timeTable.addPart(availableManagement.getPart());

                                Collections.sort(availableGuides);
                                for (Management availableGuide : availableGuides) {
                                    if (!availableGuide.getName().equals(availableManagement.getName())) {
                                        if (i == 1 && timeTables.get(0).getGuide().equals(availableGuide.getName())) {
                                            continue;
                                        }

                                        timeTable.addGuide(availableGuide.getName());
                                        AvailableTime guideTime = availableTimeRepository.findByManagementAndCode(availableGuide, code);
                                        if (guideTime != null) {
                                            guideTime.arrange();
                                            availableTimeRepository.save(guideTime);
                                            availableGuide.increaseArrangementCount();
                                            managementRepository.save(availableGuide);
                                            isFixed = true;
                                        }
                                        break;
                                    }
                                }
                            } else if (timeTable.getApplicantTwo() == null
                                    && !timeTable.getManagementOne().equals(availableManagement.getName())
                                    && !timeTable.getGuide().equals(availableManagement.getName())) {
                                if (i == 1
                                        && timeTables.get(0).getManagementTwo() != null
                                        && timeTables.get(0).getManagementTwo().equals(availableManagement.getName())) {
                                    continue;
                                }

                                applicant.arrange();
                                applicantRepository.save(applicant);
                                availableManagement.increaseInterviewCount();
                                managementRepository.save(availableManagement);
                                timeTable.addApplicantTwo(applicant.getName());
                                timeTable.addManagementTwo(availableManagement.getName());

                                for (Management availableGuide : availableGuides) {
                                    if (!availableGuide.getName().equals(availableManagement.getName())) {
                                        if (i == 1 && timeTables.get(0).getGuide().equals(availableGuide.getName())) {
                                            continue;
                                        }

                                        timeTable.addGuide(availableGuide.getName());
                                        AvailableTime guideTime = availableTimeRepository.findByManagementAndCode(availableGuide, code);
                                        if (guideTime != null) {
                                            guideTime.arrange();
                                            availableTimeRepository.save(guideTime);
                                            availableGuide.increaseArrangementCount();
                                            managementRepository.save(availableGuide);
                                            isFixed = true;
                                        }
                                        break;
                                    }
                                }
                            } else {
                                continue;
                            }

                            timeTableRepository.save(timeTable);
                            AvailableTime managementTime = availableTimeRepository.findByManagementAndCode(availableManagement, code);
                            if (managementTime != null) {
                                managementTime.arrange();
                                availableTimeRepository.save(managementTime);
                            }
                            break;
                        }
                        if (isFixed) {
                            break;
                        }
                    }
                    if (isFixed) {
                        break;
                    }
                }
                if (isFixed) {
                    break;
                }
            }
        }
    }
}