package tarun.bth.App.process;

import tarun.bth.App.db.LoginDAO;
import tarun.bth.App.db.entity.Login;

import javax.ws.rs.NotFoundException;
import java.util.Optional;


public interface LoginProcess {
    //private LoginDAO loginDAO;

    //public LoginProcess(LoginDAO loginDAO) {
      //  this.loginDAO = loginDAO;
    //}
    Login create(Login login);

    //public Login find(Integer id) throws NotFoundException{
        //return Optional
          //      .ofNullable(this.loginDAO.findBy(id))
             //   .orElseThrow(() -> new NotFoundException("Admin password does not match"));
    //public Login find(Integer id){
    //    return this.loginDAO.findBy(id);
    //}
}
