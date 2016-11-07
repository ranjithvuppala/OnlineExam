package tarun.bth.App.resource;

import tarun.bth.App.db.entity.Question;
import tarun.bth.App.db.entity.QuestionName;
import tarun.bth.App.process.QuestionProcess;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

@Path("QuestionPaper")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class QuestionResource {
    private QuestionProcess questionProcess;

    public QuestionResource(QuestionProcess questionProcess) {
        this.questionProcess = checkNotNull(questionProcess);
    }

    @GET
    @Path("/all/")
    public List<Question> getAllQuestions() {
        return questionProcess.getAllQuestions();
    }

    @GET
    @Path("/onlyquestions/")
    public List<QuestionName> getOnlyQuestions() {
        return questionProcess.getOnlyQuestions();
    }

   @POST
    public Question createQuestion(Question question) {
        return this.questionProcess.create(question);
       /*if (question != null) {
           examPaperDAO.create(question);
           throw new WebApplicationException(Response.Status.OK);
       } else {
           throw new WebApplicationException(Response.Status.BAD_REQUEST);
       }*/
    }
    @GET
    @Path("/{question_id}")
    public Question getQuestionById(@PathParam("question_id") int question_id) {
        return questionProcess.find(question_id);
    }

    @PUT
    @Path("/{question_id}")
    public Question updateQuestion(@PathParam("question_id") int question_id, Question question){


        /*Question question= examPaperDAO.findQuestionById(question_id);
        question.setQuestion(updatedexamPaper.getQuestion());
        question.setFirstoption(updatedexamPaper.getFirstoption());
        question.setSecondoption(updatedexamPaper.getSecondoption());
        question.setThirdoption(updatedexamPaper.getThirdoption());
        question.setFourthoption(updatedexamPaper.getFourthoption());

        return examPaperDAO.update(question_id,question);*/
        return this.questionProcess.update(question_id, question);
    }

    @DELETE
    @Path("/{question_id}")
    public void deleteQuestion(@PathParam("question_id") int question_id) {
        this.questionProcess.delete(question_id);
    }

}
