package br.com.phpimenta.taskmanagerapi.service.impl;

import br.com.phpimenta.taskmanagerapi.model.TaskCategory;
import br.com.phpimenta.taskmanagerapi.repository.TaskCategoryRepository;
import br.com.phpimenta.taskmanagerapi.repository.TaskCategoryRepositorySpecification;
import br.com.phpimenta.taskmanagerapi.repository.filter.TaskCategoryRepositoryFilter;
import br.com.phpimenta.taskmanagerapi.service.TaskCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskCategoryServiceImpl implements TaskCategoryService {

    @Autowired
    private TaskCategoryRepository taskCategoryRepository;

    @Override
    public void delete(Integer id) {
        taskCategoryRepository.deleteById(id);
    }

    @Override
    public Optional<TaskCategory> get(Integer id) {
        return taskCategoryRepository.findById(id);
    }

    @Override
    public Page<TaskCategory> getByPageAndFilter(Pageable pageable, TaskCategoryRepositoryFilter taskCategoryRepositoryFilter) {
        Specification<TaskCategory> specification = Specification.where(null);
        if (taskCategoryRepositoryFilter != null) {
            if (!taskCategoryRepositoryFilter.getName().isBlank()) {
                specification = specification.or(
                        TaskCategoryRepositorySpecification.byName(taskCategoryRepositoryFilter.getName())
                );
            }
        }
        return taskCategoryRepository.findAll(specification, pageable);
    }

    @Override
    public TaskCategory save(TaskCategory taskCategory) {
        return taskCategoryRepository.save(taskCategory);
    }
}
