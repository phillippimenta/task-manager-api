package br.com.phpimenta.taskmanagerapi.service;

import br.com.phpimenta.taskmanagerapi.model.TaskCategory;
import br.com.phpimenta.taskmanagerapi.repository.filter.TaskCategoryRepositoryFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TaskCategoryService {

    void delete(Integer id);

    Optional<TaskCategory> get(Integer id);

    Page<TaskCategory> getByPageAndFilter(Pageable pageable, TaskCategoryRepositoryFilter taskCategoryRepositoryFilter);

    TaskCategory save(TaskCategory taskCategory);
}
