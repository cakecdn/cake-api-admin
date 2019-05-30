package net.cakecdn.api.admin.traffic.service;

import net.cakecdn.api.admin.traffic.entity.UserRemainingTraffic;
import net.cakecdn.api.admin.traffic.entity.TrafficLog;
import net.cakecdn.api.admin.traffic.repository.UserRemainingTrafficRepository;
import net.cakecdn.api.admin.traffic.repository.TrafficLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TrafficServiceImpl implements TrafficService {

    private final UserRemainingTrafficRepository userRemainingTrafficRepository;
    private final TrafficLogRepository trafficLogRepository;

    @Autowired
    public TrafficServiceImpl(
            UserRemainingTrafficRepository userRemainingTrafficRepository,
            TrafficLogRepository trafficLogRepository
    ) {
        this.userRemainingTrafficRepository = userRemainingTrafficRepository;
        this.trafficLogRepository = trafficLogRepository;
    }

    @Override
    public UserRemainingTraffic useTraffics(Long userId, Long using) {
        UserRemainingTraffic remainingTraffic = userRemainingTrafficRepository.findByUserId(userId).orElse(new UserRemainingTraffic(userId, 0L));
        remainingTraffic.setRemainingTrafficBytes(remainingTraffic.getRemainingTrafficBytes() - using);
        userRemainingTrafficRepository.save(remainingTraffic);
        return remainingTraffic;
    }

    @Override
    @Transactional
    public Map<Long, Long> useTraffics(Map<Long, Long> usingMap, String nodeName) {
        List<UserRemainingTraffic> userRemainingTraffics = userRemainingTrafficRepository.findAll();
        Map<Long, Long> userRemainingTrafficMap = UserRemainingTraffic.toMap(userRemainingTraffics);
        List<TrafficLog> trafficLogs = new ArrayList<>();

        for (Map.Entry<Long, Long> e : usingMap.entrySet()) {
            Long userId = e.getKey();
            Long using = e.getValue();
            Long newRemainingTraffic = userRemainingTrafficMap.getOrDefault(userId, 0L) - using;
            userRemainingTrafficMap.put(userId, newRemainingTraffic);
            trafficLogs.add(new TrafficLog(userId, using, nodeName));
        }

        List<UserRemainingTraffic> userRemainingTrafficList = UserRemainingTraffic.toList(userRemainingTrafficMap);
        userRemainingTrafficRepository.saveAll(userRemainingTrafficList);
        trafficLogRepository.saveAll(trafficLogs);

        return userRemainingTrafficMap;
    }
}
