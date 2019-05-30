package net.cakecdn.api.admin.traffic.service;

import net.cakecdn.api.admin.traffic.entity.UserRemainingTraffic;

import java.util.Map;

public interface TrafficService {

    UserRemainingTraffic useTraffics(Long userId, Long using);

    Map<Long, Long> useTraffics(Map<Long, Long> usingMap, String nodeName);
}
