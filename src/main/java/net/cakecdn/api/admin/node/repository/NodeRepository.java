package net.cakecdn.api.admin.node.repository;

import net.cakecdn.api.admin.node.domain.Node;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NodeRepository extends JpaRepository<Node, Long> {
    Page<Node> findAll(Pageable pageable);
}
