package net.cakecdn.api.admin.node.service;

import net.cakecdn.api.admin.all.domain.dto.CustomPage;
import net.cakecdn.api.admin.node.domain.Node;
import net.cakecdn.api.admin.node.repository.NodeRepository;
import net.cakecdn.api.admin.all.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author Okeyja
 * @version 2019/04/25 025 22:10
 */
@Service
public class NodeServiceImpl implements NodeService {
    private final NodeRepository nodeRepository;

    @Autowired
    public NodeServiceImpl(NodeRepository nodeRepository) {
        this.nodeRepository = nodeRepository;
    }

    @Override
    public Node get(long id) throws ResourceNotFoundException {
        return nodeRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public CustomPage<Node> page(int page, int size) {
        Pageable pageRequest = PageRequest.of(page, size);
        Page<Node> nodePage = nodeRepository.findAll(pageRequest);
        return CustomPage.build(nodePage).withPage(page);
    }

    @Override
    public void add(Node node) {
        node.setId(null);
        nodeRepository.save(node);
    }

    @Override
    public void edit(Node node, long id) {
        node.setId(id);
        nodeRepository.save(node);

    }

    @Override
    public void delete(long id) {
        nodeRepository.deleteById(id);
    }
}
