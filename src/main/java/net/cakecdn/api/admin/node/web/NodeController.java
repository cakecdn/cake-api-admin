package net.cakecdn.api.admin.node.web;

import net.cakecdn.api.admin.all.domain.dto.AjaxResult;
import net.cakecdn.api.admin.all.domain.dto.CustomPage;
import net.cakecdn.api.admin.all.exception.ResourceNotFoundException;
import net.cakecdn.api.admin.node.domain.Node;
import net.cakecdn.api.admin.node.domain.NodeHealthStatus;
import net.cakecdn.api.admin.node.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Okeyja
 * @version 2019/04/25 025 23:05
 */
@RestController
@RequestMapping("/nodes")
public class NodeController {
    private final NodeService nodeService;

    @Autowired
    public NodeController(NodeService nodeService) {
        this.nodeService = nodeService;
    }

    @GetMapping("/{id}")
    public AjaxResult get(@PathVariable long id) throws ResourceNotFoundException {
        Node customPage = nodeService.get(id);
        return AjaxResult.success(customPage);
    }

    @GetMapping
    public AjaxResult list(@RequestParam int page, @RequestParam int size) {
        CustomPage customPage = nodeService.page(page, size);
        return AjaxResult.success(customPage);
    }

    @PostMapping
    public AjaxResult add(Node node) {
        nodeService.add(node);
        return AjaxResult.success();
    }

    @PutMapping("/{id}")
    public AjaxResult update(Node node, @PathVariable long id) {
        nodeService.edit(node, id);
        return AjaxResult.success();
    }

    @DeleteMapping("/{id}")
    public AjaxResult delete(@PathVariable long id) {
        nodeService.delete(id);
        return AjaxResult.success();
    }

    @PostMapping("/{id}/health-status")
    public AjaxResult pulse(@PathVariable long id, NodeHealthStatus nodeHealthStatus) {
        return AjaxResult.success(nodeHealthStatus);
    }
}
