CREATE SEQUENCE IF NOT EXISTS app_users_id_seq;
CREATE TABLE IF NOT EXISTS app_users (
    app_user_id INTEGER DEFAULT app_users_id_seq.nextval PRIMARY KEY,
    name VARCHAR(60) NOT NULL,
    birthdate DATE NOT NULL,
    app_user_role_fk INTEGER NOT NULL,
    created_at TIMESTAMP NULL,
    updated_at TIMESTAMP NULL,
    FOREIGN KEY (app_user_role_fk) REFERENCES app_user_roles (app_user_role_id)
);

CREATE TRIGGER app_users_created_at_trigger
BEFORE INSERT
ON app_users
FOR EACH ROW CALL "br.com.phpimenta.taskmanagerapi.infrastructure.database.h2.trigger.CreatedAtTrigger";

CREATE TRIGGER app_users_updated_at_trigger
BEFORE UPDATE
ON app_users
FOR EACH ROW CALL "br.com.phpimenta.taskmanagerapi.infrastructure.database.h2.trigger.UpdatedAtTrigger";