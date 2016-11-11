package tarun.bth.App.resource;

import tarun.bth.App.db.entity.Choice;
import tarun.bth.App.process.ChoiceProcess;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;


@RolesAllowed("ADMIN")
@Path("Choice")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ChoiceResource {
    private  ChoiceProcess choiceProcess;

    public ChoiceResource(ChoiceProcess choiceProcess) {
        this.choiceProcess = checkNotNull(choiceProcess);
    }

    @POST
    public Choice createChoice(Choice choice) {
        return this.choiceProcess.create(choice);
    }

    @GET
    public List<Choice> getAllChoices() {
            return choiceProcess.getAllChoices();
    }

    @DELETE
    @Path("/{id}")
    public void deleteQuestion(@PathParam("id") int id) {
        this.choiceProcess.delete(id);
    }
    @PUT
    @Path("/{id}")
    public Choice updateChoice(@PathParam("id") int id, Choice choice){
        return this.choiceProcess.update(id, choice);
    }


}
