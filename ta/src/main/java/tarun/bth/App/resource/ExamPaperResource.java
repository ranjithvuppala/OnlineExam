package tarun.bth.App.resource;

import tarun.bth.App.db.ExamPaperDAO;
import tarun.bth.App.db.entity.ExamPaper;
import tarun.bth.App.db.entity.Login;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("QuestionPaper")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ExamPaperResource {
    private ExamPaperDAO examPaperDAO;

    public ExamPaperResource(ExamPaperDAO examPaperDAO) {
        this.examPaperDAO=examPaperDAO;
    }

    @GET
    @Path("/all/")
    public List<ExamPaper> getAllQuestions() {
        return examPaperDAO.getAllQuestions();
    }

   @POST
    public int createQuestion(ExamPaper examPaper) {
       // return this.examPaperDAO.create(examPaper);
       if (examPaper != null) {
           examPaperDAO.create(examPaper);
           throw new WebApplicationException(Response.Status.OK);
       } else {
           throw new WebApplicationException(Response.Status.BAD_REQUEST);
       }
    }
    @GET
    @Path("/{question_id}")
    public ExamPaper getLoginById(@PathParam("question_id") int question_id) {
        return examPaperDAO.findQuestionById(question_id);
    }

    @DELETE
    @
    /*@GET
    public String getWords(){
        return "Hello World,";
    }*/
}
