package tarun.bth.App.auth;

import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;
import tarun.bth.App.db.entity.User;
import tarun.bth.App.process.UserProcess;

import java.util.Optional;


public class ExamAuthenticator implements Authenticator<BasicCredentials, User> {
    private UserProcess userProcess;

    public ExamAuthenticator(UserProcess userProcess){
        this.userProcess = userProcess;
    }


    @Override
    public Optional<User> authenticate(BasicCredentials credentials) throws AuthenticationException {
        User user = new User(credentials.getUsername(),credentials.getPassword());
        return Optional.ofNullable(this.userProcess.verify(user));

    }
}