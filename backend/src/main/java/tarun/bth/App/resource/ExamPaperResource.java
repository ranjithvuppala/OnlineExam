package tarun.bth.App.resource;

import tarun.bth.App.db.ExamPaperDAO;
import tarun.bth.App.db.entity.ExamPaper;
import tarun.bth.App.db.entity.Login;
import tarun.bth.App.process.ExamPaperProcess;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

@Path("QuestionPaper")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ExamPaperResource {
    private ExamPaperProcess examPaperProcess;

    public ExamPaperResource(ExamPaperProcess examPaperProcess) {
        this.examPaperProcess = checkNotNull(examPaperProcess);
    }

<<<<<<< HEAD
    @GET
    @Path("/all/")
=======

    @RolesAllowed("ADMIN")
    @GET
>>>>>>> 1fc339960e07781733b31613e8263323dde29757
    public List<ExamPaper> getAllQuestions() {
        return examPaperProcess.getAllQuestions();
    }

   @POST
    public ExamPaper createQuestion(ExamPaper examPaper) {
        return this.examPaperProcess.create(examPaper);
       /*if (examPaper != null) {
           examPaperDAO.create(examPaper);
           throw new WebApplicationException(Response.Status.OK);
       } else {
           throw new WebApplicationException(Response.Status.BAD_REQUEST);
       }*/
    }
    @GET
    @Path("/{question_id}")
    public ExamPaper getQuestionById(@PathParam("question_id") int question_id) {
        return examPaperProcess.find(question_id);
    }

    @PUT
    @Path("/{question_id}")
    public ExamPaper updateQuestion(@PathParam("question_id") int question_id, ExamPaper examPaper){


        /*ExamPaper examPaper= examPaperDAO.findQuestionById(question_id);
        examPaper.setQuestion(updatedexamPaper.getQuestion());
        examPaper.setFirstoption(updatedexamPaper.getFirstoption());
        examPaper.setSecondoption(updatedexamPaper.getSecondoption());
        examPaper.setThirdoption(updatedexamPaper.getThirdoption());
        examPaper.setFourthoption(updatedexamPaper.getFourthoption());

        return examPaperDAO.update(question_id,examPaper);*/
        return this.examPaperProcess.update(question_id,examPaper);
    }

    @DELETE
    @Path("/{question_id}")
    public void deleteQuestion(@PathParam("question_id") int question_id) {
        this.examPaperProcess.delete(question_id);
    }
    /*@GET
    public String getWords(){
        return "Hello World,";
    }*/
}
