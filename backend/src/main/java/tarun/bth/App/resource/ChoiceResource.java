package tarun.bth.App.resource;

import tarun.bth.App.db.entity.Choice;
import tarun.bth.App.process.ChoiceProcess;
import tarun.bth.App.process.QuestionChoiceProcess;
import tarun.bth.App.process.QuestionProcess;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;


@RolesAllowed("ADMIN")
@Path("Choice")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ChoiceResource {
    private ChoiceProcess choiceProcess;


    public ChoiceResource(ChoiceProcess choiceProcess) {
        this.choiceProcess = checkNotNull(choiceProcess);
    }

    @POST
    public Choice createChoice(@Valid Choice choice) {
        return this.choiceProcess.create(choice);
    }

    @GET
    public List<Choice> getAllChoices() {
            return this.choiceProcess.getAllChoices();
    }

    @DELETE
    @Path("/{choice_id}")
    public void deleteQuestion(@PathParam("choice_id") int choice_id) {
        this.choiceProcess.delete(choice_id);
    }
    @PUT
    @Path("/{choice_id}")
    public Choice updateChoice(@PathParam("choice_id") int choice_id, Choice choice){
        return this.choiceProcess.update(choice_id, choice);
    }

}
