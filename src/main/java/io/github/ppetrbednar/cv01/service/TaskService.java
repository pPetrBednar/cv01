package io.github.ppetrbednar.cv01.service;

import io.github.ppetrbednar.cv01.domain.Task;
import io.github.ppetrbednar.cv01.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Transactional(readOnly = true)
    public List<Task> findAllByAuthorId(final Long authorId) {
        return taskRepository.findAllByAuthorId(authorId);
    }
}
