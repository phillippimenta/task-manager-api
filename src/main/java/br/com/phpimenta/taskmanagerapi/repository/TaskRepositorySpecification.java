package br.com.phpimenta.taskmanagerapi.repository;

import br.com.phpimenta.taskmanagerapi.model.Task;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class TaskRepositorySpecification {

    public static Specification<Task> byTitle(String title) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get("title")),
                "%" + title.toLowerCase() + "%");
    }

    public static Specification<Task> byExpectedData(LocalDate expectedDate) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(
                criteriaBuilder.lower(root.get("expectedDate")),
                expectedDate);
    }

}
