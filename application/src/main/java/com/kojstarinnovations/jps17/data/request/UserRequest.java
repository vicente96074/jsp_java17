package com.kojstarinnovations.jps17.data.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Request class for User
 *
 * @author Augusto Vicente
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRequest {

    private String username;
    private String email;
    private String password;
}
