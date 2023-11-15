package com.kojstarinnovations.conjava17.infrastructure.adapters.input.controller.data.response;

import com.kojstarinnovations.conjava17.domain.enums.ElementStatus;
import com.kojstarinnovations.conjava17.domain.enums.RolName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RolResponse {
    private RolName rolName;
    private ElementStatus elementStatus;
}
