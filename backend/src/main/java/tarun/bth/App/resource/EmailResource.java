package tarun.bth.App.resource;

import tarun.bth.App.db.entity.Email;
import tarun.bth.App.process.EmailProcess;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RolesAllowed("ADMIN")
@Path("Mail")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class EmailResource {

    private EmailProcess emailProcess;

    public EmailResource(EmailProcess emailProcess) {
        this.emailProcess = emailProcess;
    }

    @POST
    public Integer sendMail(Email email){
        return this.emailProcess.send(email);
    }


}
