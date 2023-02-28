package io.github.ppetrbednar.cv01.repository;

import io.github.ppetrbednar.cv01.domain.Task;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {
}
