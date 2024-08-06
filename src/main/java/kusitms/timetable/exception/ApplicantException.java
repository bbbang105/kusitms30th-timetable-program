package kusitms.timetable.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ApplicantException extends RuntimeException{
    private final ApplicantErrorResult applicantErrorResult;

    @Override
    public String getMessage() {
        return applicantErrorResult.getMessage();
    }
}