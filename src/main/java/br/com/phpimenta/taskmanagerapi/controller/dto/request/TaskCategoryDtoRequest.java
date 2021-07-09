package br.com.phpimenta.taskmanagerapi.controller.dto.request;

import br.com.phpimenta.taskmanagerapi.model.TaskCategory;
import lombok.Data;

/**
 * Class responsible for representing a DTO request object
 *
 * @author Phillip Pimenta - phillip@phpimenta.com.br
 * @since 1.0.0
 */
@Data
public class TaskCategoryDtoRequest {

    private String name;

    public TaskCategory converter() {
        TaskCategory taskCategory = new TaskCategory();
        taskCategory.setName(name);
        return taskCategory;
    }
}
