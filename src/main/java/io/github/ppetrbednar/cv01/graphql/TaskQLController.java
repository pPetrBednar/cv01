package io.github.ppetrbednar.cv01.graphql;

import io.github.ppetrbednar.cv01.domain.Task;
import io.github.ppetrbednar.cv01.dto.AppUserDto;
import io.github.ppetrbednar.cv01.dto.TaskDto;
import io.github.ppetrbednar.cv01.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class TaskQLController {

    private final TaskService taskService;

    @SchemaMapping(typeName = "AppUser")
    public List<TaskDto> tasks(final AppUserDto appUserDto) {
        return taskService.findAllByAuthorId(appUserDto.getId())
                .stream()
                .map(Task::toDto)
                .collect(Collectors.toList());
    }

}
