package br.com.phpimenta.taskmanagerapi.controller.dto.response;

import br.com.phpimenta.taskmanagerapi.model.TaskCategory;
import lombok.Data;

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
public class TaskCategoryDtoResponse {

    private Integer id;

    private String name;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public TaskCategoryDtoResponse(TaskCategory taskCategory) {
        this.id = taskCategory.getId();
        this.name = taskCategory.getName();
        this.createdAt = taskCategory.getCreatedAt();
        this.updatedAt = taskCategory.getUpdatedAt();
    }

    public static List<TaskCategoryDtoResponse> convert(List<TaskCategory> taskCategories) {
        List<TaskCategoryDtoResponse> taskCategoryDtoResponseList = new ArrayList<>();
        taskCategories.forEach(taskCategory -> {
            taskCategoryDtoResponseList.add(new TaskCategoryDtoResponse(taskCategory));
        });
        return taskCategoryDtoResponseList;
    }
}
