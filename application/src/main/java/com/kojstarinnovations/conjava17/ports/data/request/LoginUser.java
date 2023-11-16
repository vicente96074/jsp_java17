package com.kojstarinnovations.conjava17.ports.data.request;

import com.kojstarinnovations.conjava17.ports.enums.RolName;
import com.kojstarinnovations.conjava17.ports.data.response.RolResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Login user model
 *
 * This class is used to map the login user
 * from the request body
 * to the login controller
 * and then to the login service
 *
 * @author Augusto Vicente
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginUser {
    private String username;
    private String password;

    public Boolean hasRol(String rolName) {
        if (roles == null) {
            return false;
        }

        for (RolResponse role : roles) {
            RolName rolUserLogged = role.getRolName();
            RolName rolFromFront = RolName.valueOf(rolName);

            if (rolUserLogged == rolFromFront) {
                Logger.getLogger(LoginUser.class.getName()).log(Level.INFO, "Return true for: {0}", rolName);
                return true;
            }
        }

        Logger.getLogger(LoginUser.class.getName()).log(Level.INFO, "Return false for: {0}", rolName);
        return false;
    }

    private List<RolResponse> roles;
}
