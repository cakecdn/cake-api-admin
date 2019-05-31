package net.cakecdn.api.admin.traffic.web;

import net.cakecdn.api.admin.traffic.entity.UserRemainingTraffic;
import net.cakecdn.api.admin.traffic.service.TrafficService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/system/traffics")
public class SystemTrafficController {

    private final TrafficService trafficService;

    @Autowired
    public SystemTrafficController(TrafficService trafficService) {
        this.trafficService = trafficService;
    }

    @PostMapping("/exchange")
    public UserRemainingTraffic useTraffics(
            @RequestParam Long userId,
            @RequestBody Long trafficBytes
    ) {
        return trafficService.useTraffics(userId, trafficBytes);
    }
}
