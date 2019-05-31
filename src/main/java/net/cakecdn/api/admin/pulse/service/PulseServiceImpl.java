package net.cakecdn.api.admin.pulse.service;

import net.cakecdn.api.admin.node.domain.Node;
import net.cakecdn.api.admin.node.repository.NodeRepository;
import net.cakecdn.api.admin.pulse.domain.PulseMeta;
import net.cakecdn.api.admin.traffic.entity.TrafficLog;
import net.cakecdn.api.admin.traffic.entity.UserRemainingTraffic;
import net.cakecdn.api.admin.traffic.repository.TrafficLogRepository;
import net.cakecdn.api.admin.traffic.repository.UserRemainingTrafficRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class PulseServiceImpl implements PulseService {

    private final NodeRepository nodeRepository;
    private final UserRemainingTrafficRepository userRemainingTrafficRepository;
    private final TrafficLogRepository trafficLogRepository;

    @Autowired
    public PulseServiceImpl(NodeRepository nodeRepository, UserRemainingTrafficRepository userRemainingTrafficRepository, TrafficLogRepository trafficLogRepository) {
        this.nodeRepository = nodeRepository;
        this.userRemainingTrafficRepository = userRemainingTrafficRepository;
        this.trafficLogRepository = trafficLogRepository;
    }

    @Override
    @Transactional
    public PulseMeta pulse(PulseMeta pulseMeta) {

        String tag = pulseMeta.getTag();
        Map<Long, Long> usingMap = pulseMeta.getUserUsed();

        Node node = nodeRepository.findByTag(tag).orElse(new Node(tag));

        List<UserRemainingTraffic> userRemainingTraffics = userRemainingTrafficRepository.findAll();
        Map<Long, Long> userRemainingTrafficMap = UserRemainingTraffic.toMap(userRemainingTraffics);
        List<TrafficLog> trafficLogs = new ArrayList<>();

        long totalUsing = 0L;
        for (Map.Entry<Long, Long> e : usingMap.entrySet()) {
            Long userId = e.getKey();
            Long using = e.getValue();
            Long newRemainingTraffic = userRemainingTrafficMap.getOrDefault(userId, 0L) - using;
            userRemainingTrafficMap.put(userId, newRemainingTraffic);
            trafficLogs.add(new TrafficLog(userId, using, tag));
            totalUsing += using;
        }

        node.setRemainingTrafficBytes(node.getRemainingTrafficBytes() - totalUsing);      // 设置节点流量
        node.setLastPulse(new Date());                                                    // 设置最后一次心跳时间

        List<UserRemainingTraffic> userRemainingTrafficList = UserRemainingTraffic.toList(userRemainingTrafficMap);
        userRemainingTrafficRepository.saveAll(userRemainingTrafficList);
        trafficLogRepository.saveAll(trafficLogs);
        nodeRepository.save(node);

        pulseMeta.setUserRemaining(userRemainingTrafficMap);
        pulseMeta.setNodeRemaining(node.getRemainingTrafficBytes());
        pulseMeta.setUploadPath(node.getUploadUrl());
        pulseMeta.setDownloadPath(node.getDownloadUrl());

        return pulseMeta;
    }
}
