package br.com.phpimenta.taskmanagerapi.controller;

import br.com.phpimenta.taskmanagerapi.controller.dto.request.TaskCategoryDtoRequest;
import br.com.phpimenta.taskmanagerapi.controller.dto.response.TaskCategoryDtoResponse;
import br.com.phpimenta.taskmanagerapi.model.TaskCategory;
import br.com.phpimenta.taskmanagerapi.repository.filter.TaskCategoryRepositoryFilter;
import br.com.phpimenta.taskmanagerapi.service.TaskCategoryService;
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
 * Class responsible for controlling the resource of a Task Category in the application
 *
 * @author Phillip Pimenta - phillip@phpimenta.com.br
 * @since 1.0.0
 */
@RestController
@RequestMapping("/task-categories")
public class TaskCategoryController extends AbstractAppController {

    private static final long serialVersionUID = 3367569323024640009L;

    @Autowired
    private TaskCategoryService taskCategoryService;

    @ApiOperation(value = "Returns a list of task categories")
    @GetMapping
    public List<TaskCategoryDtoResponse> getByPageAndFilter(Pageable pageable, TaskCategoryRepositoryFilter taskCategoryRepositoryFilter) {
        List<TaskCategory> taskCategories = taskCategoryService.getByPageAndFilter(pageable, taskCategoryRepositoryFilter).getContent();
        return TaskCategoryDtoResponse.convert(taskCategories);
    }

    @ApiOperation(value = "Returns a task category by id")
    @GetMapping("/{id}")
    public ResponseEntity<TaskCategoryDtoResponse> get(@PathVariable Integer id) {
        Optional<TaskCategory> optionalTaskCategory = taskCategoryService.get(id);
        if (optionalTaskCategory.isPresent()) {
            return ResponseEntity.ok(new TaskCategoryDtoResponse(optionalTaskCategory.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @ApiOperation(value = "Create a task category category")
    @PostMapping
    @Transactional
    public ResponseEntity<TaskCategoryDtoResponse> post(
            @Valid @RequestBody TaskCategoryDtoRequest taskCategoryDtoRequest,
            UriComponentsBuilder uriBuilder
    ) {
        TaskCategory taskCategory = taskCategoryDtoRequest.converter();
        taskCategoryService.save(taskCategory);
        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(taskCategory.getId()).toUri();
        return ResponseEntity.created(uri).body(new TaskCategoryDtoResponse(taskCategory));
    }

    @ApiOperation(value = "Update a task category category")
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TaskCategoryDtoResponse> put(
            @PathVariable Integer id,
            @Valid @RequestBody TaskCategoryDtoRequest taskCategoryDtoRequest
    ) {
        Optional<TaskCategory> optionalTaskCategory = taskCategoryService.get(id);
        if (optionalTaskCategory.isPresent()) {
            TaskCategory taskCategory = taskCategoryDtoRequest.converter();
            taskCategory.setId(id);
            taskCategoryService.save(taskCategory);
            return ResponseEntity.ok(new TaskCategoryDtoResponse(taskCategory));
        }
        return ResponseEntity.notFound().build();
    }

    @ApiOperation(value = "Remove a task category by id")
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Optional<TaskCategory> optionalTaskCategory = taskCategoryService.get(id);
        if (optionalTaskCategory.isPresent()) {
            taskCategoryService.delete(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
