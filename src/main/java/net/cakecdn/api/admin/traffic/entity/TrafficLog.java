package net.cakecdn.api.admin.traffic.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TrafficLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long trafficBytes;
    private Date logTime;
    private String nodeName;

    public TrafficLog(Long userId, Long using, String nodeName) {
        this.userId = userId;
        this.trafficBytes = using;
        this.logTime = new Date();
        this.nodeName = nodeName;
    }
}
