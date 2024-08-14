package kusitms.timetable.domain;

import jakarta.persistence.*;
import kusitms.timetable.common.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "managements")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Management extends BaseEntity implements Comparable<Management> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "managements_id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "part", nullable = false)
    private String part;

    @Column(name = "guide_count", nullable = false)
    private int guideCount;

    @Column(name = "interview_count", nullable = false)
    private int interviewCount;

    @Builder
    public Management(String name, String part) {
        this.name = name;
        this.part = part;
        this.guideCount = 0;
        this.interviewCount = 0;
    }

    public void increaseArrangementCount() {
        this.guideCount++;
    }

    public void increaseInterviewCount() {
        this.interviewCount++;
    }

    @Override
    public int compareTo(Management other) {
        return Integer.compare(this.guideCount + this.interviewCount, other.guideCount + this.interviewCount);
    }
}