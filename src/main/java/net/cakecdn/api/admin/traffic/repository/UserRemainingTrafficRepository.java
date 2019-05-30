package net.cakecdn.api.admin.traffic.repository;

import net.cakecdn.api.admin.traffic.entity.UserRemainingTraffic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRemainingTrafficRepository extends JpaRepository<UserRemainingTraffic, Long> {
    Optional<UserRemainingTraffic> findByUserId(Long userId);
}
