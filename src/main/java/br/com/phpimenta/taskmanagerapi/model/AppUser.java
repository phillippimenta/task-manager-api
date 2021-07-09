package br.com.phpimenta.taskmanagerapi.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "app_users")
@SequenceGenerator(name = "app_users_id_seq", sequenceName = "app_users_id_seq", allocationSize = 1)
@Data
public class AppUser {

    @Id
    @GeneratedValue(generator = "app_users_id_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "app_user_id")
    private Integer id;

    private String name;

    private LocalDate birthdate;

    private String email;

    private String password;

    @ManyToOne
    @JoinColumn(name = "app_user_role_fk")
    private AppUserRole role;

    @Column(name="created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name="updated_at", insertable = false, updatable = false)
    private LocalDateTime updatedAt;
}
