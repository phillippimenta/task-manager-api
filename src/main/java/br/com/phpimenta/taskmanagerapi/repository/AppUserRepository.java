package br.com.phpimenta.taskmanagerapi.repository;

import br.com.phpimenta.taskmanagerapi.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Integer> {
}
