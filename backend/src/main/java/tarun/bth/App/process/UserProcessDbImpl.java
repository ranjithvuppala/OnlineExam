package tarun.bth.App.process;

import tarun.bth.App.db.UserDAO;
import tarun.bth.App.db.entity.User;

import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.NotFoundException;
import java.util.List;
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

    @Override
    public User verifyForPost(User user) throws NotAuthorizedException {

        User test = this.userDAO.findUserByUsername(user);

        if(test!= null){
            if(test.getRole().equals("adm")){ return test;}
            else{throw new NotAuthorizedException("Login Unsuccessful");}
        }
        else {
            throw new NotAuthorizedException("Login Unsuccessful");
        }
    }

    @Override
    public User create(User user) {
        return this.userDAO.findUserById(this.userDAO.create(user));
    }


    @Override
    public List<User> getList(String role) {
        return this.userDAO.getUsersByRole(role);
    }
}
