package tarun.bth.App.resource;

import tarun.bth.App.db.ExamPaperDAO;
import tarun.bth.App.db.entity.ExamPaper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
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
        return this.examPaperDAO.create(examPaper);
    }

    @GET
    public String getWords(){
        return "Hello World,";
    }
}
