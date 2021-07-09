CREATE SEQUENCE IF NOT EXISTS tasks_id_seq;
CREATE TABLE IF NOT EXISTS tasks (
    task_id INTEGER DEFAULT tasks_id_seq.nextval PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description CLOB NULL,
    due_date DATE NOT NULL,
    completed BOOLEAN NOT NULL,
    task_category_fk INTEGER NOT NULL,
    created_at TIMESTAMP NULL,
    updated_at TIMESTAMP NULL,
    FOREIGN KEY (task_category_fk) REFERENCES task_categories (task_category_id)
);

CREATE TRIGGER tasks_created_at_trigger
BEFORE INSERT
ON tasks
FOR EACH ROW CALL "br.com.phpimenta.taskmanagerapi.infrastructure.database.h2.trigger.CreatedAtTrigger";

CREATE TRIGGER tasks_updated_at_trigger
BEFORE UPDATE
ON tasks
FOR EACH ROW CALL "br.com.phpimenta.taskmanagerapi.infrastructure.database.h2.trigger.UpdatedAtTrigger";