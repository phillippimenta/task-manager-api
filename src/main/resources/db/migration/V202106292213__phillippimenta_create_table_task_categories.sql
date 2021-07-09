CREATE SEQUENCE IF NOT EXISTS task_categories_id_seq;
CREATE TABLE IF NOT EXISTS task_categories (
    task_category_id INTEGER DEFAULT task_categories_id_seq.nextval PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NULL,
    updated_at TIMESTAMP NULL
);

CREATE TRIGGER task_categories_created_at_trigger
BEFORE INSERT
ON task_categories
FOR EACH ROW CALL "br.com.phpimenta.taskmanagerapi.infrastructure.database.h2.trigger.CreatedAtTrigger";

CREATE TRIGGER task_categories_updated_at_trigger
BEFORE UPDATE
ON task_categories
FOR EACH ROW CALL "br.com.phpimenta.taskmanagerapi.infrastructure.database.h2.trigger.UpdatedAtTrigger";