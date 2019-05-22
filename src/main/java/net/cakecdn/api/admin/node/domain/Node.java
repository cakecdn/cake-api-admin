package net.cakecdn.api.admin.node.domain;

import lombok.*;

import javax.persistence.*;

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

    @Column(length = 64, unique = true)
    private String name;

    private String uploadUrl;

    private String downloadUrl;

    private String healthCheckUrl;

    private Long healthCheckPulse;

    private Long totalTrafficBytes;

    private Long usedTrafficBytes;

    @Enumerated(EnumType.STRING)
    private NodeHealthEnum healthStatus;
}
