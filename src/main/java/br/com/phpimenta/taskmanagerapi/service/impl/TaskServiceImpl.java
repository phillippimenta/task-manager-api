package br.com.phpimenta.taskmanagerapi.service.impl;

import br.com.phpimenta.taskmanagerapi.model.Task;
import br.com.phpimenta.taskmanagerapi.repository.TaskRepository;
import br.com.phpimenta.taskmanagerapi.repository.TaskRepositorySpecification;
import br.com.phpimenta.taskmanagerapi.repository.filter.TaskRepositoryFilter;
import br.com.phpimenta.taskmanagerapi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public void delete(Integer id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Optional<Task> get(Integer id) {
        return taskRepository.findById(id);
    }

    @Override
    public Page<Task> getByPageAndFilter(Pageable pageable, TaskRepositoryFilter taskRepositoryFilter) {
        Specification<Task> specification = Specification.where(null);
        if (taskRepositoryFilter != null) {
            if (!taskRepositoryFilter.getTitle().isBlank()) {
                specification = specification.or(
                        TaskRepositorySpecification.byTitle(taskRepositoryFilter.getTitle())
                );
            }

            if (taskRepositoryFilter.getExpectedDate() != null) {
                specification = specification.or(
                        TaskRepositorySpecification.byExpectedData(taskRepositoryFilter.getExpectedDate())
                );
            }
        }
        return taskRepository.findAll(specification, pageable);
    }

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }
}
