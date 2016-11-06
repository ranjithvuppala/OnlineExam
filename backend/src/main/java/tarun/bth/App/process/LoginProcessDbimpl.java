package tarun.bth.App.process;

import tarun.bth.App.db.LoginDAO;
import tarun.bth.App.db.entity.Login;

import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.NotFoundException;
import java.util.Optional;

public class LoginProcessDbImpl implements LoginProcess{
    private LoginDAO loginDAO;
    public LoginProcessDbImpl(LoginDAO loginDAO){this.loginDAO=loginDAO;}

    @Override
    public Login verify(Login login) throws NotFoundException{
        return Optional
                .ofNullable(this.loginDAO.findUserByUsername(login))
                .orElseThrow(() -> new NotAuthorizedException("Invalid Credentials"));

    }
}
