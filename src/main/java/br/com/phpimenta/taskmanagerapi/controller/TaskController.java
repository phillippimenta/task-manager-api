package br.com.phpimenta.taskmanagerapi.controller;

import br.com.phpimenta.taskmanagerapi.controller.dto.request.TaskDtoRequest;
import br.com.phpimenta.taskmanagerapi.controller.dto.response.TaskDtoResponse;
import br.com.phpimenta.taskmanagerapi.model.Task;
import br.com.phpimenta.taskmanagerapi.repository.filter.TaskRepositoryFilter;
import br.com.phpimenta.taskmanagerapi.service.TaskCategoryService;
import br.com.phpimenta.taskmanagerapi.service.TaskService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

/**
 * Class responsible for controlling the resource of a Task in the application
 *
 * @author Phillip Pimenta - phillip@phpimenta.com.br
 * @since 1.0.0
 */
@RestController
@RequestMapping("/tasks")
public class TaskController extends AbstractAppController {

    private static final long serialVersionUID = -4604857581091303176L;

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskCategoryService taskCategoryService;

    @ApiOperation(value = "Returns a list of tasks")
    @GetMapping
    public List<TaskDtoResponse> getByPageAndFilter(Pageable pageable, TaskRepositoryFilter taskRepositoryFilter) {
        List<Task> taskList = taskService.getByPageAndFilter(pageable, taskRepositoryFilter).getContent();
        return TaskDtoResponse.convert(taskList);
    }

    @ApiOperation(value = "Returns a task by id")
    @GetMapping("/{id}")
    public ResponseEntity<TaskDtoResponse> get(@PathVariable Integer id) {
        Optional<Task> optionalTask = taskService.get(id);
        if (optionalTask.isPresent()) {
            return ResponseEntity.ok(new TaskDtoResponse(optionalTask.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @ApiOperation(value = "Create a task")
    @PostMapping
    @Transactional
    public ResponseEntity<TaskDtoResponse> post(
            @Valid @RequestBody TaskDtoRequest taskForm,
            UriComponentsBuilder uriBuilder
    ) {
        Task task = taskForm.converter(taskCategoryService);
        taskService.save(task);
        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(task.getId()).toUri();
        return ResponseEntity.created(uri).body(new TaskDtoResponse(task));
    }

    @ApiOperation(value = "Update a task")
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TaskDtoResponse> put(
            @PathVariable Integer id,
            @Valid @RequestBody TaskDtoRequest taskForm
    ) {
        Optional<Task> optionalTask = taskService.get(id);
        if (optionalTask.isPresent()) {
            Task task = taskForm.converter(taskCategoryService);
            task.setId(id);
            taskService.save(task);
            return ResponseEntity.ok(new TaskDtoResponse(task));
        }
        return ResponseEntity.notFound().build();
    }

    @ApiOperation(value = "Remove a task by id")
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Optional<Task> optionalTask = taskService.get(id);
        if (optionalTask.isPresent()) {
            taskService.delete(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
