package io.github.ppetrbednar.cv01.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUserInputDto {
    @NotNull
    @NotBlank
    @Size(max = 256, message = "Username limit 256.")
    private String username;
    @NotNull
    @NotBlank
    @Size(max = 256, message = "Password limit 256.")
    private String password;
    @NotNull
    private Boolean active;
    @NotNull
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;

    public AppUserInputDto(String username, String password, Boolean active, String creationDate, String updateDate) {
        this.username = username;
        this.password = password;
        this.active = active;
        this.creationDate = LocalDateTime.parse(creationDate, DateTimeFormatter.ISO_DATE_TIME);
        this.updateDate = LocalDateTime.parse(updateDate, DateTimeFormatter.ISO_DATE_TIME);;
    }
}
