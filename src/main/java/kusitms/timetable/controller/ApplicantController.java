package kusitms.timetable.controller;

import kusitms.timetable.common.ApiResponse;
import kusitms.timetable.common.constant.SuccessStatus;
import kusitms.timetable.dto.ApplicantDto;
import kusitms.timetable.service.ApplicantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/applicants")
public class ApplicantController {
    private final ApplicantService applicantService;

    // 지원자 정보 개인 등록 API
    @PostMapping("/action-add")
    public ResponseEntity<ApiResponse<SuccessStatus>> addApplicant(
            @RequestBody ApplicantDto.addApplicantRequest addApplicantRequest) {
        applicantService.addApplicant(addApplicantRequest);

        return ApiResponse.onSuccess(SuccessStatus._ADD_APPLICANT);
    }

    // 지원자 정보 일괄 등록 API
    @PostMapping("all/action-add")
    public ResponseEntity<ApiResponse<SuccessStatus>> addAllApplicants(
            @RequestBody List<ApplicantDto.addApplicantRequest> addApplicantRequests) {

        for (ApplicantDto.addApplicantRequest addApplicantRequest : addApplicantRequests) {
            applicantService.addApplicant(addApplicantRequest);
        }

        return ApiResponse.onSuccess(SuccessStatus._ADD_ALL_APPLICANTS);
    }
}