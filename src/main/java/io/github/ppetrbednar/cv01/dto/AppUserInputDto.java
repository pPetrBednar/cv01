package io.github.ppetrbednar.cv01.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

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
    private Boolean active;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;
}
