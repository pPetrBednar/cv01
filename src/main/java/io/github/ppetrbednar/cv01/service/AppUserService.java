package io.github.ppetrbednar.cv01.service;

import io.github.ppetrbednar.cv01.domain.AppUser;
import io.github.ppetrbednar.cv01.dto.AppUserInputDto;
import io.github.ppetrbednar.cv01.repository.AppUserRepository;
import io.github.ppetrbednar.cv01.service.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AppUserService {
    private final AppUserRepository appUserRepository;

    @Transactional(readOnly = true)
    public Optional<AppUser> findById(final Long id) throws ResourceNotFoundException {

       var result =  appUserRepository.findById(id);
        if (result.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        return result;
    }

    @Transactional(readOnly = true)
    public List<AppUser> findAllByActiveEquals(final Boolean active) {
        return appUserRepository.findAllByActiveEquals(active);
    }

    @Transactional
    public AppUser create(final AppUser entity) {
        return appUserRepository.save(entity);
    }

    @Transactional
    public AppUser update(final AppUser entity) throws ResourceNotFoundException {
        if (!appUserRepository.existsById(entity.getId())) {
            throw new ResourceNotFoundException();
        }
        return appUserRepository.save(entity);
    }

    @Transactional
    public void delete(final Long id) throws ResourceNotFoundException {
        if (!appUserRepository.existsById(id)) {
            throw new ResourceNotFoundException();
        }
        appUserRepository.deleteById(id);
    }
}
