package net.cakecdn.api.admin.code.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RechargeCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 20)
    private Long id;

    @Column(length = 64, unique = true)
    private String code;

    private Long trafficBytes;
    private Date created;
    private Date expire;

    @Column(length = 20)
    private Long userId;

    public RechargeCode(int days) {
        this.code = UUID.randomUUID().toString().replace("-", "");
        this.code += UUID.randomUUID().toString().replace("-", "");
        this.created = new Date();          // 默认为当前时间
        this.trafficBytes = 107374182400L;  // 100GB

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(created);
        calendar.add(Calendar.DATE, days); // 30天后
        this.expire = calendar.getTime();        // 30天后超时
    }
}
