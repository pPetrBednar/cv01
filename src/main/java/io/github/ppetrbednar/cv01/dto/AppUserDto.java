package io.github.ppetrbednar.cv01.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AppUserDto {
    private Long id;
    private String username;
    private String password;
    private Boolean active;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;
}
