package net.cakecdn.api.admin.node.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Okeyja
 * @version 2019/04/29 029 11:37
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NodeHealthStatus {
    private NodeHealthEnum heathStatus;
}
