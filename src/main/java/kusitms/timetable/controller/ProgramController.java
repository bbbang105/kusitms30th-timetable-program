package kusitms.timetable.controller;

import kusitms.timetable.common.ApiResponse;
import kusitms.timetable.common.constant.SuccessStatus;
import kusitms.timetable.service.ProgramService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/programs")
public class ProgramController {
    private final ProgramService programService;

    // 타임 테이블 자동배정 프로그램 실행 API
    @PostMapping("/action-run")
    public ResponseEntity<ApiResponse<SuccessStatus>> runAutoArrangementProgram() {
        programService.runAutoArrangementProgram();

        return ApiResponse.onSuccess(SuccessStatus._RUN_PROGRAM);
    }
}