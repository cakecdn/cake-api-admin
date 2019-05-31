package net.cakecdn.api.admin.pulse.web;

import net.cakecdn.api.admin.pulse.domain.PulseMeta;
import net.cakecdn.api.admin.pulse.service.PulseService;
import net.cakecdn.api.admin.traffic.entity.UserRemainingTraffic;
import net.cakecdn.api.admin.traffic.service.TrafficService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/system/pulse")
public class SystemPulseController {

    private final PulseService pulseService;

    @Autowired
    public SystemPulseController(PulseService pulseService) {
        this.pulseService = pulseService;
    }

    @PostMapping
    public PulseMeta useTraffics(
            @RequestBody PulseMeta pulseMeta
    ) {
        return pulseService.pulse(pulseMeta);
    }
}
