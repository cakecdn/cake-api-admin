package net.cakecdn.api.admin.node.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * 用户直接访问的CDN终节点
 *
 * @author Okeyja
 * @version 2019/04/25 025 21:58
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Node {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 20)
    private Long id;

    private String name;

    @Column(length = 64, unique = true)
    private String tag;

    private String uploadUrl;

    private String downloadUrl;

    private int pulseThresholdMs;

    private Date lastPulse;

    private Long remainingTrafficBytes;

    public Node(String tag) {
        this.tag = tag;
        this.name = "未命名新节点";
        this.uploadUrl = "http://localhost/up";
        this.downloadUrl = "http://localhost/down";
        this.pulseThresholdMs = 30000;
        this.remainingTrafficBytes = 10737418240L;
    }
}
