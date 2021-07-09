package br.com.phpimenta.taskmanagerapi.model;

import lombok.Getter;

@Getter
public enum AppUserRoleEnum {

    USER_ROLE(1, "User Role"), ADMIN_ROLE(2, "Admin User");

    private Integer id;

    private String name;

    AppUserRoleEnum(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
