package org.workshop.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    private final LimitsConfiguration limitsConfiguration;

    @Autowired
    public LimitsController(LimitsConfiguration limitsConfiguration) {
        this.limitsConfiguration = limitsConfiguration;
    }

    @GetMapping(value = "/limits", produces = "application/json")
    public LimitsDTO getLimits() {
        return new LimitsDTO(limitsConfiguration.getMinimum(), limitsConfiguration.getMaximum());
    }
}
