package io.github.ppetrbednar.cv01.controller;

import io.github.ppetrbednar.cv01.domain.AppUser;
import io.github.ppetrbednar.cv01.dto.AppUserDto;
import io.github.ppetrbednar.cv01.dto.AppUserInputDto;
import io.github.ppetrbednar.cv01.repository.AppUserRepository;
import io.github.ppetrbednar.cv01.service.AppUserService;
import io.github.ppetrbednar.cv01.service.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app-user")
@AllArgsConstructor
public class AppUserController {

    private final AppUserService appUserService;

    @GetMapping("")
    public List<AppUser> findAll(){
        return appUserService.findAllByActiveEquals(true);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable final Long id) throws ResourceNotFoundException {
        var result = appUserService.findById(id);

        return ResponseEntity.ok(toDto(result.get()));
    }

    @PostMapping("")
    public ResponseEntity<Object> create(@RequestBody @Validated final AppUserInputDto dto) {
        var result = appUserService.create(toEntity(dto));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(toDto(result));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable final Long id, @RequestBody @Validated final AppUserInputDto dto) throws ResourceNotFoundException {
        var entity = toEntity(dto);
        entity.setId(id);
        var result = appUserService.update(entity);
        return ResponseEntity
                .status(HttpStatus.valueOf(204))
                .body(toDto(result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable final Long id) throws ResourceNotFoundException {
        appUserService.delete(id);
        return ResponseEntity.status(HttpStatus.valueOf(204)).build();
    }

    private static AppUser toEntity(final AppUserInputDto dto) {
        return new AppUser(
                dto.getUsername(),
                dto.getPassword(),
                dto.getActive(),
                dto.getCreationDate(),
                dto.getUpdateDate()
        );
    }

    private static AppUserDto toDto(final AppUser appUser) {
        return new AppUserDto(
                appUser.getId(),
                appUser.getUsername(),
                appUser.getPassword(),
                appUser.getActive(),
                appUser.getCreationDate(),
                appUser.getUpdateDate()
        );
    }
}
