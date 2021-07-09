package br.com.phpimenta.taskmanagerapi.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "app_user_roles")
@SequenceGenerator(name = "app_user_roles_id_seq", sequenceName = "app_user_roles_id_seq", allocationSize = 1)
@Data
public class AppUserRole {

    @Id
    @Column(name = "app_user_role_id")
    @GeneratedValue(generator = "app_user_roles_id_seq", strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String name;

    @Column(name="created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name="updated_at", insertable = false, updatable = false)
    private LocalDateTime updatedAt;
}
