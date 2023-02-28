package io.github.ppetrbednar.cv01.repository;

import io.github.ppetrbednar.cv01.domain.Role;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {
}
