package tarun.bth.App.resource;

import io.dropwizard.auth.Auth;
import tarun.bth.App.db.entity.User;
import tarun.bth.App.process.UserProcess;

import javax.annotation.security.PermitAll;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import static com.google.common.base.Preconditions.checkNotNull;


@Path("login")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {
    private UserProcess userProcess;

    public UserResource(UserProcess userProcess) {
        this.userProcess = checkNotNull(userProcess);
    }


    @POST
    public User verifyLogin(User user) {
        User test = this.userProcess.verifyForPost(user);
        test.setUsername(null);
        test.setPassword(null);
        test.setId(null);
        return test;
    }


    @Path("/link")
    @POST
    public User verifyLink(User user) {
       return this.userProcess.verify(user);
    }

    @PermitAll
    @Path("/link/result")
    @POST
    public Integer updateResult(User user) {
        return this.userProcess.updateResult(user);
    }

}
