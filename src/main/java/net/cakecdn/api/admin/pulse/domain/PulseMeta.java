package net.cakecdn.api.admin.pulse.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Getter
@Setter
@ToString
public class PulseMeta {
    private String tag;
    private String uploadPath;
    private String downloadPath;
    private Long nodeRemaining;
    private Long nodeUsed;
    private Map<Long, Long> userRemaining;
    private Map<Long, Long> userUsed;
}
