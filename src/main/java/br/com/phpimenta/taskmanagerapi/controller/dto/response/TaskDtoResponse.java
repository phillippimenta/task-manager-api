package br.com.phpimenta.taskmanagerapi.controller.dto.response;

import br.com.phpimenta.taskmanagerapi.model.Task;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Class responsible for representing a DTO response object
 *
 * @author Phillip Pimenta - phillip@phpimenta.com.br
 * @since 1.0.0
 */
@Data
public class TaskDtoResponse {

    private Integer id;

    private String title;

    private String description;

    private LocalDate dueDate;

    private boolean completed = false;

    private TaskCategoryDtoResponse taskCategoryResponse;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public TaskDtoResponse(Task task) {
        this.id = task.getId();
        this.title = task.getTitle();
        this.description = task.getDescription();
        this.dueDate = task.getDueDate();
        this.createdAt = task.getCreatedAt();
        this.updatedAt = task.getUpdatedAt();
        this.completed = task.isCompleted();
        if (task.getTaskCategory() != null) {
            this.taskCategoryResponse = new TaskCategoryDtoResponse(task.getTaskCategory());
        }
    }

    public static List<TaskDtoResponse> convert(List<Task> taskList) {
        List<TaskDtoResponse> taskDtoResponseList = new ArrayList<>();
        taskList.forEach(task -> {
            taskDtoResponseList.add(new TaskDtoResponse(task));
        });
        return taskDtoResponseList;
    }
}
