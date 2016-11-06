package tarun.bth.App.resource;

import com.google.common.base.Preconditions;
import io.dropwizard.auth.Auth;
import org.eclipse.jetty.server.Response;
import tarun.bth.App.db.LoginDAO;
import tarun.bth.App.db.entity.Login;
import tarun.bth.App.db.entity.LoginResult;
import tarun.bth.App.process.LoginProcess;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;


@Path("login")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoginResource {
    private LoginProcess loginProcess;

    public LoginResource (LoginProcess loginProcess) {
        this.loginProcess = checkNotNull(loginProcess);
    }


    @POST
    public Login verifyLogin( Login login) {
       return this.loginProcess.verify(login);
    }

}
