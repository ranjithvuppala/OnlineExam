package tarun.bth.App.auth;


import io.dropwizard.auth.Authorizer;
import tarun.bth.App.db.entity.Login;
import tarun.bth.App.process.LoginProcess;

import javax.ws.rs.ForbiddenException;

public class ExamAuthorizer implements Authorizer<Login> {

    private LoginProcess loginProcess;
    public ExamAuthorizer(LoginProcess loginProcess){
        this.loginProcess = loginProcess;
    }

    @Override
    public boolean authorize(Login user, String role) throws ForbiddenException {

        Login test = this.loginProcess.verify(user);
        return test.getRole().equals("adm") && role.equals("ADMIN");
    }
}
