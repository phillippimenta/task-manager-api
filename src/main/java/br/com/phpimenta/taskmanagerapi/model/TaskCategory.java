package br.com.phpimenta.taskmanagerapi.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Class responsible for representing a task category
 *
 * @author Phillip Pimenta - phillip@phpimenta.com.br
 * @since 1.0.0
 */
@Entity
@Table(name = "task_categories")
@SequenceGenerator(name = "task_categories_id_seq", sequenceName = "task_categories_id_seq", allocationSize = 1)
@Data
public class TaskCategory {

    @Id
    @GeneratedValue(generator = "task_categories_id_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "task_category_id")
    private Integer id;

    private String name;

    @Column(name="created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name="updated_at", insertable = false, updatable = false)
    private LocalDateTime updatedAt;
}
