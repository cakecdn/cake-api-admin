package net.cakecdn.api.admin.node.service;

import net.cakecdn.api.admin.CakeApiAdminApplicationTests;
import net.cakecdn.api.admin.all.domain.dto.CustomPage;
import net.cakecdn.api.admin.all.exception.ResourceNotFoundException;
import net.cakecdn.api.admin.node.domain.Node;
import net.cakecdn.api.admin.node.domain.NodeHealthEnum;
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
        Node nodeToBeSaved = new Node();
        nodeToBeSaved.setName("阿里云北京机房ECS");
        nodeToBeSaved.setUploadUrl("http://aliyun-beijing-1.node.cakecdn.net/upload");
        nodeToBeSaved.setDownloadUrl("http://aliyun-beijing-1.node.cakecdn.net/download");
        nodeToBeSaved.setHealthCheckUrl("http://aliyun-beijing-1.node.cakecdn.net/health-check");
        nodeToBeSaved.setHealthCheckPulse((long) (60 * 1000));
        nodeToBeSaved.setHealthStatus(NodeHealthEnum.HEALTHY);
        nodeToBeSaved.setTotalTrafficBytes(858993459200L);
        nodeToBeSaved.setUsedTrafficBytes(18572301L);
        nodeService.add(nodeToBeSaved);

        nodeToBeSaved = new Node();
        nodeToBeSaved.setName("腾讯云广州节点1");
        nodeToBeSaved.setUploadUrl("http://qcloud-guangzhou-1.node.cakecdn.net/upload");
        nodeToBeSaved.setDownloadUrl("http://qcloud-guangzhou-1.node.cakecdn.net/download");
        nodeToBeSaved.setHealthCheckUrl("http://qcloud-guangzhou-1.node.cakecdn.net/health-check");
        nodeToBeSaved.setHealthCheckPulse((long) (60 * 1000));
        nodeToBeSaved.setHealthStatus(NodeHealthEnum.DOWN);
        nodeToBeSaved.setTotalTrafficBytes(858993459200L);
        nodeToBeSaved.setUsedTrafficBytes(1558230L);
        nodeService.add(nodeToBeSaved);

        nodeToBeSaved = new Node();
        nodeToBeSaved.setName("华为云贵阳一机房ECS");
        nodeToBeSaved.setUploadUrl("http://huaweicloud-cn-southwest-2.node.cakecdn.net/upload");
        nodeToBeSaved.setDownloadUrl("http://huaweicloud-cn-southwest-2.node.cakecdn.net/download");
        nodeToBeSaved.setHealthCheckUrl("http://huaweicloud-cn-southwest-2.node.cakecdn.net/health-check");
        nodeToBeSaved.setHealthCheckPulse((long) (60 * 1000));
        nodeToBeSaved.setHealthStatus(NodeHealthEnum.BLOCKED);
        nodeToBeSaved.setTotalTrafficBytes(858993459200L);
        nodeToBeSaved.setUsedTrafficBytes(5148790L);
        nodeService.add(nodeToBeSaved);

        nodeToBeSaved = new Node();
        nodeToBeSaved.setName("亚马逊EC2转S3存储东京AZ-a");
        nodeToBeSaved.setUploadUrl("http://aws-ap-northeast-1a.node.cakecdn.net/upload");
        nodeToBeSaved.setDownloadUrl("https://s3-ap-northeast-1.amazonaws.com/cakecdn-test-bucket");
        nodeToBeSaved.setHealthCheckUrl("http://aws-ap-northeast-1a.node.cakecdn.net/health-check");
        nodeToBeSaved.setHealthCheckPulse((long) (60 * 1000));
        nodeToBeSaved.setHealthStatus(NodeHealthEnum.HEALTHY);
        nodeToBeSaved.setTotalTrafficBytes(858993459200L);
        nodeToBeSaved.setUsedTrafficBytes(808610275L);
        nodeService.add(nodeToBeSaved);

        nodeToBeSaved = new Node();
        nodeToBeSaved.setName("亚马逊EC2转S3存储香港AZ-a");
        nodeToBeSaved.setUploadUrl("http://aws-ap-east-1a.node.cakecdn.net/upload");
        nodeToBeSaved.setDownloadUrl("https://s3-ap-east-1.amazonaws.com/cakecdn-test-bucket");
        nodeToBeSaved.setHealthCheckUrl("http://aws-ap-east-1a.node.cakecdn.net/health-check");
        nodeToBeSaved.setHealthCheckPulse((long) (60 * 1000));
        nodeToBeSaved.setHealthStatus(NodeHealthEnum.HEALTHY);
        nodeToBeSaved.setTotalTrafficBytes(858993459200L);
        nodeToBeSaved.setUsedTrafficBytes(808610275L);
        nodeService.add(nodeToBeSaved);

        nodeToBeSaved = new Node();
        nodeToBeSaved.setName("DigitalOcean JP 1");
        nodeToBeSaved.setUploadUrl("http://digitalocean-jp-1.node.cakecdn.net/upload");
        nodeToBeSaved.setDownloadUrl("https://digitalocean-jp-1.amazonaws.com/cakecdn-test-bucket");
        nodeToBeSaved.setHealthCheckUrl("http://digitalocean-jp-1.node.cakecdn.net/health-check");
        nodeToBeSaved.setHealthCheckPulse((long) (60 * 1000));
        nodeToBeSaved.setHealthStatus(NodeHealthEnum.HEALTHY);
        nodeToBeSaved.setTotalTrafficBytes(858993459200L);
        nodeToBeSaved.setUsedTrafficBytes(808610275L);
        nodeService.add(nodeToBeSaved);
    }

    @Test
    public void edit() {
    }

    @Test
    public void delete() {
    }
}