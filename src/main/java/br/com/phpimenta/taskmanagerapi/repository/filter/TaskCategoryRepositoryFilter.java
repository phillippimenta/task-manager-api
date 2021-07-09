package br.com.phpimenta.taskmanagerapi.repository.filter;

import lombok.Data;

/**
 * Class responsible for representing the search filter to be used in the task category repository
 *
 * @author Phillip Pimenta - phillip@phpimenta.com.br
 * @since 1.0.0
 */
@Data
public class TaskCategoryRepositoryFilter {

    private String name = "";
}
