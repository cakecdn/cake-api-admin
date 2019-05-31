package net.cakecdn.api.admin.node.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NodeVo {

    private Long id;
    private String name;
    private String tag;
    private String uploadUrl;
    private String downloadUrl;
    private int pulseThresholdMs;
    private Date lastPulse;
    private NodeStatusEnum healthStatus;
    private Long remainingTrafficBytes;

    public NodeVo(Node node) {
        this.id = node.getId();
        this.name = node.getName();
        this.tag = node.getTag();
        this.uploadUrl = node.getUploadUrl();
        this.downloadUrl = node.getDownloadUrl();
        this.pulseThresholdMs = node.getPulseThresholdMs();
        this.lastPulse = node.getLastPulse();
        this.healthStatus = NodeStatusEnum.getEnum(lastPulse);
        this.remainingTrafficBytes = node.getRemainingTrafficBytes();
    }

    public static List<NodeVo> getList(List<Node> nodes) {
        List<NodeVo> vos = new ArrayList<>();
        for (Node node : nodes) {
            vos.add(new NodeVo(node));
        }
        return vos;
    }
}
