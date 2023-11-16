package com.kojstarinnovations.conjava17.ports.data.response;

import com.kojstarinnovations.conjava17.ports.enums.ElementStatus;
import com.kojstarinnovations.conjava17.ports.enums.RolName;
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
