package io.github.ppetrbednar.cv01.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
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
}
