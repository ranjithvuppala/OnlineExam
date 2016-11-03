package tarun.bth.App.auth;


import io.dropwizard.auth.Authorizer;
import tarun.bth.App.db.entity.Login;
import tarun.bth.App.process.LoginProcess;

public class ExamAuthorizer implements Authorizer<Login> {

    LoginProcess loginProcess;
    public ExamAuthorizer(LoginProcess loginProcess){
        this.loginProcess = loginProcess;
    }

    @Override
    public boolean authorize(Login user, String role) {
        return user.getUsername().equals("admin") && role.equals("ADMIN");
    }
}
