package io.github.ppetrbednar.cv01.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.ppetrbednar.cv01.dto.TaskDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
public class Task {
    @Id
    private Long id;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private LocalDateTime creationDate;
    @Column
    private LocalDateTime updateDate;
    @ManyToOne
    @JoinColumn(name="author_id", nullable=false)
    @ToString.Exclude
    @JsonIgnore
    private AppUser author;

    public TaskDto toDto() {
        return new TaskDto(
                id,
                title,
                description,
                creationDate,
                updateDate
        );
    }
}
