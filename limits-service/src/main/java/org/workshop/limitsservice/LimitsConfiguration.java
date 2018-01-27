package org.workshop.limitsservice;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "limits.service")
@Data
public class LimitsConfiguration {

    private int minimum;
    private int maximum;
}
