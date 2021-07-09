package br.com.phpimenta.taskmanagerapi.repository.filter;

import lombok.Data;

import java.time.LocalDate;

/**
 * Class responsible for representing the search filter to be used in the task repository
 *
 * @author Phillip Pimenta - phillip@phpimenta.com.br
 * @since 1.0.0
 */
@Data
public class TaskRepositoryFilter {

    private String title = "";

    private LocalDate expectedDate;
}
