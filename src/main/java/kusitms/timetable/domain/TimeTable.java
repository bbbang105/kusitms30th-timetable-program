package kusitms.timetable.domain;

import jakarta.persistence.*;
import kusitms.timetable.common.BaseEntity;
import kusitms.timetable.util.StringListConverter;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@Table(name = "time_tables")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TimeTable extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "time_tables_id")
    private Long id;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "applicants")
    @Convert(converter = StringListConverter.class)
    private List<String> applicants;

    @Column(name = "managements")
    @Convert(converter = StringListConverter.class)
    private List<String> managements;

    @Column(name = "guide")
    private String guide;

    @Column(name = "place")
    private String place;

    public void addApplicants(String applicant) {
        this.applicants.add(applicant);
    }

    public void addManagements(String managements) {
        this.managements.add(managements);
    }

    public void addGuide(String guide) {
        this.guide = guide;
    }
}