package kusitms.timetable.common.constant;


import kusitms.timetable.common.code.BaseCode;
import kusitms.timetable.common.dto.ReasonDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessStatus implements BaseCode {
    // Global
    _OK(HttpStatus.OK, "200", "성공입니다."),
    _CREATED(HttpStatus.CREATED, "201", "성공적으로 생성되었습니다."),
    // Applicant
    _ADD_APPLICANT(HttpStatus.CREATED, "201", "지원자 정보 개인 등록에 성공했습니다."),
    _ADD_ALL_APPLICANTS(HttpStatus.CREATED, "201", "지원자 정보 일괄 등록에 성공했습니다."),
    // Management
    _ADD_MANAGEMENT(HttpStatus.CREATED, "201", "운영진 정보 개인 등록에 성공했습니다."),
    _ADD_ALL_MANAGEMENTS(HttpStatus.CREATED, "201", "운영진 정보 일괄 등록에 성공했습니다."),
    // Program
    _RUN_PROGRAM(HttpStatus.OK, "200", "자동 배정 프로그램 실행에 성공했습니다."),
    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ReasonDto getReason() {
        return ReasonDto.builder()
                .isSuccess(true)
                .code(code)
                .message(message)
                .build();
    }

    @Override
    public ReasonDto getReasonHttpStatus() {
        return ReasonDto.builder()
                .isSuccess(true)
                .httpStatus(httpStatus)
                .code(code)
                .message(message)
                .build();
    }
}