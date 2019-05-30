package net.cakecdn.api.admin.traffic.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserRemainingTraffic {
    @Id
    private Long userId;
    private Long remainingTrafficBytes;

    public static Map<Long, Long> toMap(List<UserRemainingTraffic> userRemainingTraffics) {
        Map<Long, Long> map = new HashMap<>();
        for (UserRemainingTraffic traffic : userRemainingTraffics) {
            map.put(traffic.getUserId(), traffic.getRemainingTrafficBytes());
        }
        return map;
    }

    public static List<UserRemainingTraffic> toList(Map<Long, Long> userRemainingTrafficMap) {
        List<UserRemainingTraffic> list = new ArrayList<>();
        for (Map.Entry<Long, Long> e : userRemainingTrafficMap.entrySet()) {
            list.add(new UserRemainingTraffic(e.getKey(), e.getValue()));
        }
        return list;
    }
}
