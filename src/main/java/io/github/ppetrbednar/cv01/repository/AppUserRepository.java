package io.github.ppetrbednar.cv01.repository;

import io.github.ppetrbednar.cv01.domain.AppUser;
import io.github.ppetrbednar.cv01.domain.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppUserRepository extends PagingAndSortingRepository<AppUser, Long> {
    List<AppUser> findAllByActiveEquals(Boolean active);

    @Query("""
        select ap
        from AppUser ap
        inner join ap.roles r
        where r = :role
    """) // Using JPQL
    List<AppUser> findAllByRolesContaining(final Role role);
}
