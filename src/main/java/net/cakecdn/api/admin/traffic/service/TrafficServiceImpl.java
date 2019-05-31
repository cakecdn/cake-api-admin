package net.cakecdn.api.admin.traffic.service;

import net.cakecdn.api.admin.node.domain.Node;
import net.cakecdn.api.admin.node.repository.NodeRepository;
import net.cakecdn.api.admin.traffic.entity.UserRemainingTraffic;
import net.cakecdn.api.admin.traffic.entity.TrafficLog;
import net.cakecdn.api.admin.traffic.repository.UserRemainingTrafficRepository;
import net.cakecdn.api.admin.traffic.repository.TrafficLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.*;

@Service
public class TrafficServiceImpl implements TrafficService {

    private final UserRemainingTrafficRepository userRemainingTrafficRepository;

    @Autowired
    public TrafficServiceImpl(UserRemainingTrafficRepository userRemainingTrafficRepository) {
        this.userRemainingTrafficRepository = userRemainingTrafficRepository;
    }

    @Override
    public UserRemainingTraffic useTraffics(Long userId, Long using) {
        UserRemainingTraffic remainingTraffic = userRemainingTrafficRepository.findByUserId(userId).orElse(new UserRemainingTraffic(userId, 0L));
        remainingTraffic.setRemainingTrafficBytes(remainingTraffic.getRemainingTrafficBytes() - using);
        userRemainingTrafficRepository.save(remainingTraffic);
        return remainingTraffic;
    }
}
