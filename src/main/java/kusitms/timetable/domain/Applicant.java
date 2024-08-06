package kusitms.timetable.domain;

import jakarta.persistence.*;
import kusitms.timetable.common.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "applicants")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Applicant extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "applicants_id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "part", nullable = false)
    private String part;

    @Builder
    public Applicant(String name, String part) {
        this.name = name;
        this.part = part;
    }
}