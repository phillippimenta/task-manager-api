package br.com.phpimenta.taskmanagerapi.repository;

import br.com.phpimenta.taskmanagerapi.model.TaskCategory;
import org.springframework.data.jpa.domain.Specification;

public class TaskCategoryRepositorySpecification {

    public static Specification<TaskCategory> byName(String name) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get("name")),
                "%" + name.toLowerCase() + "%");
    }
}
