package net.cakecdn.api.admin.node.service;

import net.cakecdn.api.admin.all.domain.dto.CustomPage;
import net.cakecdn.api.admin.node.domain.Node;
import net.cakecdn.api.admin.all.exception.ResourceNotFoundException;
import net.cakecdn.api.admin.node.domain.NodeVo;

/**
 * @author Okeyja
 * @version 2019/04/25 025 22:08
 */
public interface NodeService {
    Node get(long id) throws ResourceNotFoundException;

    CustomPage<NodeVo> page(int page, int size);

    void add(Node node);

    void edit(Node node, long id);

    void delete(long id);
}
