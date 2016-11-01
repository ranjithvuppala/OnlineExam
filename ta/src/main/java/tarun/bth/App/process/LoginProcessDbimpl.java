/*package tarun.bth.App.process;

import tarun.bth.App.db.LoginDAO;
import tarun.bth.App.db.entity.Login;

public class LoginProcessDbimpl implements LoginProcess{
    private LoginDAO loginDAO;
    public LoginProcessDbimpl(LoginDAO loginDAO){this.loginDAO=loginDAO;}

    @Override
    public Login create(Login login) {
        return this.loginDAO.findBy(this.loginDAO.create(login));
    }
}
*/