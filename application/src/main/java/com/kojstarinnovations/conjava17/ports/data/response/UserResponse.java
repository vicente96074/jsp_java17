package com.kojstarinnovations.conjava17.ports.data.response;

import com.kojstarinnovations.conjava17.ports.enums.ElementStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Response class for User
 *
 * @author Augusto Vicente
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponse {
    private String username;
    private String email;
    private String password;
    private ElementStatus elementStatus = ElementStatus.NEW;
}
