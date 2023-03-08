package io.github.ppetrbednar.cv01.domain;

import io.github.ppetrbednar.cv01.dto.AppUserDto;
import io.github.ppetrbednar.cv01.dto.AppUserInputDto;
import io.github.ppetrbednar.cv01.dto.graphql.AppUserInputQLDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

/*
create, create-drop, validate, update a none
 */
@Entity
@NoArgsConstructor
@Data
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private Boolean active;
    @Column
    private LocalDateTime creationDate;
    @Column
    private LocalDateTime updateDate;
    @OneToMany(mappedBy = "author")
    private List<Task> tasks = Collections.emptyList();
    @ManyToMany(mappedBy = "users")
    private List<Role> roles = Collections.emptyList();

    public AppUser(String username, String password, Boolean active, LocalDateTime creationDate, LocalDateTime updateDate) {
        this.username = username;
        this.password = password;
        this.active = active;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }

    public AppUser(final AppUserInputDto dto) {
        username = dto.getUsername();
        password = dto.getPassword();
        active = dto.getActive();
        creationDate = dto.getCreationDate();
        updateDate = dto.getUpdateDate();
    }

    public AppUser(final AppUserInputQLDto dto) {
        username = dto.getUsername();
        password = dto.getPassword();
        active = dto.getActive();
        creationDate = LocalDateTime.parse(dto.getCreationDate(), DateTimeFormatter.ISO_DATE_TIME);
        updateDate = LocalDateTime.parse(dto.getUpdateDate(), DateTimeFormatter.ISO_DATE_TIME);
    }

    public AppUserDto toDto() {
        return new AppUserDto(
                getId(),
                getUsername(),
                getPassword(),
                getActive(),
                getCreationDate(),
                getUpdateDate()
        );
    }
}
