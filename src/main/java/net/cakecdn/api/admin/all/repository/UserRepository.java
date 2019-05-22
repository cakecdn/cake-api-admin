package net.cakecdn.api.admin.all.repository;

import net.cakecdn.api.admin.all.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
