package tarun.bth.App.auth;



import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;
import tarun.bth.App.db.entity.Login;
import tarun.bth.App.process.LoginProcess;


import javax.ws.rs.ForbiddenException;
import java.util.Optional;


public class ExamAuthenticator implements Authenticator<BasicCredentials, Login> {
    private LoginProcess loginProcess;

    public ExamAuthenticator(LoginProcess loginProcess){
        this.loginProcess = loginProcess;
    }


    @Override
    public Optional<Login> authenticate(BasicCredentials credentials) throws AuthenticationException {
        Login login = new Login(credentials.getUsername(),credentials.getPassword());
        return Optional.ofNullable(this.loginProcess.verify(login));

    }
}