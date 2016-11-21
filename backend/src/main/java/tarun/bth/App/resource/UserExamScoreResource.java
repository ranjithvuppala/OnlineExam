package tarun.bth.App.resource;


import tarun.bth.App.db.entity.User;
import tarun.bth.App.db.entity.UserExamScore;
import tarun.bth.App.process.UserExamScoreProcess;

import javax.annotation.security.PermitAll;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@PermitAll
@Path("userExam")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserExamScoreResource {
    private UserExamScoreProcess userExamScoreProcess;

    public UserExamScoreResource(UserExamScoreProcess userExamScoreProcess) {
        this.userExamScoreProcess = userExamScoreProcess;
    }

    @Path("/{Id}")
    @GET
    public UserExamScore findById(@PathParam("Id") Integer Id){
       return this.userExamScoreProcess.findbyId(Id);
    }

    @Path("/result")
    @POST
    public Integer updateResult(UserExamScore userExamScore) {
        return this.userExamScoreProcess.updateResult(userExamScore);
    }
}



