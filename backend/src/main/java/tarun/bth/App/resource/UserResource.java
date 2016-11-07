package tarun.bth.App.resource;

import io.dropwizard.auth.Auth;
import tarun.bth.App.db.entity.User;
import tarun.bth.App.process.UserProcess;

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


    @GET
    @Path("/logout")
    public String logout(@Auth User user){
        System.out.println(user);
        return user.getUsername();
    }

    @POST
    public User verifyLogin(User user) {
        return this.userProcess.verify(user);
    }

}
