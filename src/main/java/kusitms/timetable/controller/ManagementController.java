package kusitms.timetable.controller;

import kusitms.timetable.common.ApiResponse;
import kusitms.timetable.common.constant.SuccessStatus;
import kusitms.timetable.dto.ManagementDto;
import kusitms.timetable.service.ManagementService;
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
@RequestMapping("/api/v1/managements")
public class ManagementController {
    private final ManagementService managementService;

    // 운영진 정보 개인 등록 API
    @PostMapping("/action-add")
    public ResponseEntity<ApiResponse<SuccessStatus>> addManagement(
            @RequestBody ManagementDto.addManagementRequest addManagementRequest) {
        managementService.addManagement(addManagementRequest);

        return ApiResponse.onSuccess(SuccessStatus._ADD_MANAGEMENT);
    }

    // 운영진 정보 일괄 등록 API
    @PostMapping("all/action-add")
    public ResponseEntity<ApiResponse<SuccessStatus>> addAllManagements(
            @RequestBody List<ManagementDto.addManagementRequest> addManagementRequests) {

        for (ManagementDto.addManagementRequest addManagementRequest : addManagementRequests) {
            managementService.addManagement(addManagementRequest);
        }

        return ApiResponse.onSuccess(SuccessStatus._ADD_ALL_MANAGEMENTS);
    }
}