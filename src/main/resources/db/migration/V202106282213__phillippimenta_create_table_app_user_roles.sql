CREATE SEQUENCE IF NOT EXISTS app_user_roles_id_seq;
CREATE TABLE IF NOT EXISTS app_user_roles (
    app_user_role_id INTEGER DEFAULT app_user_roles_id_seq.nextval PRIMARY KEY,
    name VARCHAR(60) NOT NULL,
    created_at TIMESTAMP NULL,
    updated_at TIMESTAMP NULL
);

CREATE TRIGGER app_user_roles_created_at_trigger
BEFORE INSERT
ON app_user_roles
FOR EACH ROW CALL "br.com.phpimenta.taskmanagerapi.infrastructure.database.h2.trigger.CreatedAtTrigger";

CREATE TRIGGER app_user_roles_updated_at_trigger
BEFORE UPDATE
ON app_user_roles
FOR EACH ROW CALL "br.com.phpimenta.taskmanagerapi.infrastructure.database.h2.trigger.UpdatedAtTrigger";