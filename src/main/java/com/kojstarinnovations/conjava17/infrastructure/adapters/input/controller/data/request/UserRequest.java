package com.kojstarinnovations.conjava17.infrastructure.adapters.input.controller.data.request;

import com.kojstarinnovations.conjava17.infrastructure.adapters.input.controller.data.validation.DataRequired;
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

    @DataRequired(message = "The username is required")
    private String username;

    @DataRequired(message = "The email is required")
    private String email;

    @DataRequired(message = "The password is required")
    private String password;
}
