package br.com.phpimenta.taskmanagerapi.service;

import br.com.phpimenta.taskmanagerapi.model.Task;
import br.com.phpimenta.taskmanagerapi.repository.filter.TaskRepositoryFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TaskService {

    void delete(Integer id);

    Optional<Task> get(Integer id);

    Page<Task> getByPageAndFilter(Pageable pageable, TaskRepositoryFilter taskRepositoryFilter);

    Task save(Task task);
}
