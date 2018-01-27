package org.workshop.limitsservice;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LimitsDTO {
    private int minimum;
    private int maximum;
}
