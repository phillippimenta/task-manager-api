INSERT INTO app_user_roles (
    app_user_role_id,
    name
) VALUES (
    1,
    'USER_ROLE'
), (
    2,
    'ADMIN_ROLE'
);

ALTER SEQUENCE app_user_roles_id_seq RESTART WITH 3;