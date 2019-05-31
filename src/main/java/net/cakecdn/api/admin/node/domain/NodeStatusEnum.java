package net.cakecdn.api.admin.node.domain;

import java.util.Date;

public enum NodeStatusEnum {
    HEALTHY, BLOCKED, UNHEALTHY, OFFLINE;

    public static NodeStatusEnum getEnum(Date lastPulse) {
        if (lastPulse == null) {
            return BLOCKED;
        }
        Date now = new Date();
        long timeDifference = now.getTime() - lastPulse.getTime();

        if (timeDifference > 12000 * 1000) {
            return OFFLINE;
        }
        if (timeDifference > 1200 * 1000) {
            return UNHEALTHY;
        }
        if (timeDifference > 120 * 1000) {
            return BLOCKED;
        }
        return HEALTHY;
    }
}
