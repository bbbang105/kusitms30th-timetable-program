package kusitms.timetable.exception;

import kusitms.timetable.common.ApiResponse;
import kusitms.timetable.common.code.BaseErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    // Applicant Error
    @ExceptionHandler(ApplicantException.class)
    public ResponseEntity<ApiResponse<BaseErrorCode>> handleTokenException(ApplicantException e) {
        ApplicantErrorResult errorResult = e.getApplicantErrorResult();
        return ApiResponse.onFailure(errorResult);
    }
}