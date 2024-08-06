package kusitms.timetable.domain;

import jakarta.persistence.*;
import kusitms.timetable.common.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "available_times")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AvailableTime extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "available_times_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "applicants_id", foreignKey = @ForeignKey(name = "available_times_fk_applicants_id"))
    private Applicant applicant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "managements_id", foreignKey = @ForeignKey(name = "available_times_fk_managements_id"))
    private Management management;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "is_arrange", nullable = false)
    private Boolean isArrange;

    @Builder
    public AvailableTime(Applicant applicant, Management management, String code) {
        this.applicant = applicant;
        this.management = management;
        this.code = code;
        this.isArrange = false;
    }

    public void arrange() {
        this.isArrange = true;
    }
}