package net.cakecdn.api.admin.node.service;

import net.cakecdn.api.admin.CakeApiAdminApplicationTests;
import net.cakecdn.api.admin.all.domain.dto.CustomPage;
import net.cakecdn.api.admin.all.exception.ResourceNotFoundException;
import net.cakecdn.api.admin.node.domain.Node;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class NodeServiceImplTest extends CakeApiAdminApplicationTests {

    @Autowired
    private NodeServiceImpl nodeService;

    @Test
    public void get() throws ResourceNotFoundException {
        Node node = nodeService.get(1L);
        System.out.println(node);
    }

    @Test
    public void page() {
        CustomPage page = nodeService.page(0, 5);
        System.out.println(page);
    }

    @Test
    public void add() {
    }

    @Test
    public void edit() {
    }

    @Test
    public void delete() {
    }
}