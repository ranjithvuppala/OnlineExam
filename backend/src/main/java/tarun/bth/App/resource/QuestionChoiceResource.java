package tarun.bth.App.resource;


import tarun.bth.App.db.entity.QuestionChoice;
import tarun.bth.App.process.QuestionChoiceProcess;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
    public QuestionChoice createQuestionChoice(QuestionChoice questionChoice) {
        return this.questionChoiceProcess.create(questionChoice);
    }


}
