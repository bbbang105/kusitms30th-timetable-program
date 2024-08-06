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
public class Management extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "managements_id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "part", nullable = false)
    private String part;

    @Column(name = "arrangement_count", nullable = false)
    private int arrangementCount;

    @Builder
    public Management(String name, String part) {
        this.name = name;
        this.part = part;
        this.arrangementCount = 0;
    }

    public void increaseArrangementCount() {
        this.arrangementCount++;
    }
}