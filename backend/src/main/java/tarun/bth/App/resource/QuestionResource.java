package tarun.bth.App.resource;

import tarun.bth.App.db.entity.Choice;
import tarun.bth.App.db.entity.Question;
import tarun.bth.App.db.entity.QuestionResponse;
import tarun.bth.App.process.ChoiceProcess;
import tarun.bth.App.process.QuestionChoiceProcess;
import tarun.bth.App.process.QuestionProcess;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

//@RolesAllowed("ADMIN")
@Path("QuestionPaper")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class QuestionResource {
    private QuestionProcess questionProcess;

    private QuestionChoiceProcess questionChoiceProcess;

    private ChoiceProcess choiceProcess;


    public QuestionResource(QuestionProcess questionProcess, QuestionChoiceProcess questionChoiceProcess, ChoiceProcess choiceProcess) {
        this.questionProcess = checkNotNull(questionProcess);
        this.questionChoiceProcess = checkNotNull(questionChoiceProcess);
        this.choiceProcess = checkNotNull(choiceProcess);

    }

    @GET
    public List<Question> getAllQuestions() {
        return this.questionProcess.getAllQuestions();
    }

   @POST
    public Question createQuestion(Question question) {
        return this.questionProcess.create(question);
    }

    @GET
    @Path("/{question_id}")
    public QuestionResponse getQuestionById(@PathParam("question_id") int question_id) {

        List<Integer> choiceIdList = this.questionChoiceProcess.find(question_id);
        List<Choice> choiceList = this.choiceProcess.findList(choiceIdList);
        Question question= this.questionProcess.find(question_id);
        question.setCorrectChoice_id(null);
        QuestionResponse questionResponse = new QuestionResponse(question,choiceList);

        questionResponse.setQuestion(question);
        questionResponse.setChoiceList(choiceList);

        return questionResponse;
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
