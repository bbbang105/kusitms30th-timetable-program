package kusitms.timetable.domain;

import jakarta.persistence.*;
import kusitms.timetable.common.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    @Column(name = "part")
    private String part;

    @Column(name = "applicant_one")
    private String applicantOne;

    @Column(name = "applicant_two")
    private String applicantTwo;

    @Column(name = "management_one")
    private String managementOne;

    @Column(name = "management_two")
    private String managementTwo;

    @Column(name = "guide")
    private String guide;

    @Column(name = "place")
    private String place;

    public void addPart(String part) {
        this.part = part;
    }

    public void addApplicantOne(String applicantOne) {
        this.applicantOne = applicantOne;
    }

    public void addApplicantTwo(String applicantTwo) {
        this.applicantTwo = applicantTwo;
    }

    public void addManagementOne(String managementOne) {
        this.managementOne = managementOne;
    }

    public void addManagementTwo(String managementTwo) {
        this.managementTwo = managementTwo;
    }

    public void addGuide(String guide) {
        this.guide = guide;
    }
}