package io.github.ppetrbednar.cv01.repository;

import io.github.ppetrbednar.cv01.domain.Task;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {
    List<Task> findAllByAuthorId(final Long authorId);
}
