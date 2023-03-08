package io.github.ppetrbednar.cv01.graphql;

import io.github.ppetrbednar.cv01.domain.AppUser;
import io.github.ppetrbednar.cv01.dto.AppUserDto;
import io.github.ppetrbednar.cv01.dto.AppUserInputDto;
import io.github.ppetrbednar.cv01.dto.graphql.AppUserInputQLDto;
import io.github.ppetrbednar.cv01.graphql.exception.ResourceNotFoundQLException;
import io.github.ppetrbednar.cv01.service.AppUserService;
import io.github.ppetrbednar.cv01.service.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;

@Controller
@AllArgsConstructor
public class AppUserQLController {
    private final AppUserService appUserService;

    @QueryMapping
    public AppUserDto appUser(@Argument final Long id) throws ResourceNotFoundQLException {
        try {
            return appUserService.findById(id).get().toDto();
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundQLException("App User with ID: " + id + " not found.");
        }
    }

    @MutationMapping
    public AppUserDto addNewAppUser(@Argument @Validated final AppUserInputQLDto appUserInputQLDto) {
        return appUserService.create(new AppUser(appUserInputQLDto)).toDto();
    }
}
