package tarun.bth.App.auth;

import io.dropwizard.auth.Authorizer;
import tarun.bth.App.db.entity.User;
import tarun.bth.App.process.UserProcess;

import javax.ws.rs.ForbiddenException;

public class ExamAuthorizer implements Authorizer<User> {

    private UserProcess userProcess;
    public ExamAuthorizer(UserProcess userProcess){
        this.userProcess = userProcess;
    }

    @Override
    public boolean authorize(User user, String role) throws ForbiddenException {

        User test = this.userProcess.verify(user);
        return test.getRole().equals("adm") && role.equals("ADMIN");
    }
}