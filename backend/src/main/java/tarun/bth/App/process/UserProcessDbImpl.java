package tarun.bth.App.process;

import tarun.bth.App.db.UserDAO;
import tarun.bth.App.db.entity.User;

import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.NotFoundException;
import java.util.Optional;

public class UserProcessDbImpl implements UserProcess {
    private UserDAO userDAO;
    public UserProcessDbImpl(UserDAO userDAO){this.userDAO = userDAO;}

    @Override
    public User verify(User user) throws NotAuthorizedException{
        return Optional
                .ofNullable(this.userDAO.findUserByUsername(user))
                .orElseThrow(() -> new NotAuthorizedException("Invalid Credentials"));

    }
}