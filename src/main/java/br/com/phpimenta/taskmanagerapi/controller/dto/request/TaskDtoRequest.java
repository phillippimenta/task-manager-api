package br.com.phpimenta.taskmanagerapi.controller.dto.request;

import br.com.phpimenta.taskmanagerapi.model.Task;
import br.com.phpimenta.taskmanagerapi.model.TaskCategory;
import br.com.phpimenta.taskmanagerapi.service.TaskCategoryService;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Optional;

/**
 * Class responsible for representing a DTO request object
 *
 * @author Phillip Pimenta - phillip@phpimenta.com.br
 * @since 1.0.0
 */
@Data
public class TaskDtoRequest {

    @NotBlank
    private String title;

    private String description;

    @NotNull
    private LocalDate dueDate;

    @NotNull
    private Boolean completed;

    @NotNull
    private Integer taskCategoryId;

    public Task converter(TaskCategoryService taskCategoryService) {
        Task task = new Task();
        task.setTitle(title);
        task.setDescription(description);
        task.setDueDate(dueDate);
        task.setCompleted(completed);
        Optional<TaskCategory> optionalTaskCategory = taskCategoryService.get(
                taskCategoryId
        );
        if (optionalTaskCategory.isPresent()) {
            task.setTaskCategory(optionalTaskCategory.get());
        }
        return task;
    }
}
