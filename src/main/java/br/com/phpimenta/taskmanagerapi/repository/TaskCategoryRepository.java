package br.com.phpimenta.taskmanagerapi.repository;

import br.com.phpimenta.taskmanagerapi.model.TaskCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Interface responsible for abstracting data storage and allows your business
 * logic to define read and write operations at a logical level.
 *
 * @author Phillip Pimenta - phillip@phpimenta.com.br
 * @since 1.0.0
 */
@Repository
public interface TaskCategoryRepository extends JpaRepository<TaskCategory, Integer>, JpaSpecificationExecutor<TaskCategory> {
}
