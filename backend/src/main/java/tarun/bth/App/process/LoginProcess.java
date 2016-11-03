package tarun.bth.App.process;

import tarun.bth.App.db.LoginDAO;
import tarun.bth.App.db.entity.Login;

import javax.ws.rs.NotFoundException;
import java.util.Optional;


public interface LoginProcess {


    Login verify(Login login);
}
