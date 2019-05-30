package net.cakecdn.api.admin.traffic.repository;

import net.cakecdn.api.admin.traffic.entity.TrafficLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrafficLogRepository extends JpaRepository<TrafficLog, Long> {
    Optional<TrafficLog> findByUserId(Long userId);
}
