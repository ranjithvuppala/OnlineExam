package tarun.bth.App.resource;


import tarun.bth.App.db.entity.QuestionChoice;
import tarun.bth.App.process.QuestionChoiceProcess;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

@Path("QuestionChoice")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class QuestionChoiceResource {
    private QuestionChoiceProcess questionChoiceProcess;

    public QuestionChoiceResource(QuestionChoiceProcess questionChoiceProcess) {
        this.questionChoiceProcess = checkNotNull(questionChoiceProcess);
    }

    @POST
    public int createQuestionChoice(List<QuestionChoice> questionChoice) {
        return this.questionChoiceProcess.create(questionChoice);
    }

    @GET
    @Path("/{question_id}")
    public List<QuestionChoice> createQuestionChoice(@PathParam("question_id") int question_id) {
        return this.questionChoiceProcess.find(question_id);
    }


}
