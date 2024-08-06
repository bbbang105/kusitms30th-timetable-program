package kusitms.timetable.common.code;


import kusitms.timetable.common.dto.ReasonDto;

public interface BaseCode {
    public ReasonDto getReason();

    public ReasonDto getReasonHttpStatus();
}