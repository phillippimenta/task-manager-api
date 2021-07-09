package br.com.phpimenta.taskmanagerapi.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Class responsible for representing a task
 *
 * @author Phillip Pimenta - phillip@phpimenta.com.br
 * @since 1.0.0
 */
@Entity
@Table(name = "tasks")
@SequenceGenerator(name = "tasks_id_seq", sequenceName = "tasks_id_seq", allocationSize = 1)
@Data
public class Task {

    @Id
    @GeneratedValue(generator = "tasks_id_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "task_id")
    private Integer id;

    private String title;

    private String description;

    @Column(name = "due_date")
    private LocalDate dueDate;

    private boolean completed = false;

    @ManyToOne
    @JoinColumn(name = "task_category_fk")
    private TaskCategory taskCategory;

    @Column(name="created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name="updated_at", insertable = false, updatable = false)
    private LocalDateTime updatedAt;
}
