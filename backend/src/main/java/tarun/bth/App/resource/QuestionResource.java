package tarun.bth.App.resource;

import tarun.bth.App.db.entity.Choice;
import tarun.bth.App.db.entity.Question;
import tarun.bth.App.db.entity.QuestionResponse;
import tarun.bth.App.process.ChoiceProcess;
import tarun.bth.App.process.ExamQuestionProcess;
import tarun.bth.App.process.QuestionChoiceProcess;
import tarun.bth.App.process.QuestionProcess;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

@RolesAllowed("ADMIN")
@Path("QuestionPaper")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class QuestionResource {
    private QuestionProcess questionProcess;


    public QuestionResource(QuestionProcess questionProcess) {
        this.questionProcess = checkNotNull(questionProcess);

    }

    @GET
    public List<QuestionResponse> getAllQuestions() {
        return this.questionProcess.getAllQuestions();
    }

    @Path("/all")
    @GET
    public List<Question> getAll() {
        return this.questionProcess.getAll();
    }

   @POST
    public Question createQuestion(@Valid Question question) {
        return this.questionProcess.create(question);
    }

    @GET
    @Path("/{question_id}")
    public QuestionResponse getQuestionById(@PathParam("question_id") int question_id) {

        return questionProcess.find(question_id);
    }

    @PUT
    @Path("/{question_id}")
    public Question updateQuestion(@PathParam("question_id") int question_id, Question question){
        return this.questionProcess.update(question_id, question);
    }

    @DELETE
    @Path("/{question_id}")
    public void deleteQuestion(@PathParam("question_id") int question_id) {
        this.questionProcess.delete(question_id);
    }

}
