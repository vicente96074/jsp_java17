package com.kojstarinnovations.jps17.data.response;

import com.kojstarinnovations.jps17.enums.ElementStatus;
import com.kojstarinnovations.jps17.enums.RolName;
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
