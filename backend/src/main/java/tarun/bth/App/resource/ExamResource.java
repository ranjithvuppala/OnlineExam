package tarun.bth.App.resource;

/**
 * Created by souji on 08/11/16.
 */
import tarun.bth.App.db.entity.Exam;
import tarun.bth.App.process.ExamProcess;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

//@RolesAllowed("ADMIN")
@Path("ExamProcess")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ExamResource {
    private ExamProcess examProcess;

    public ExamResource(ExamProcess examProcess) {
        this.examProcess = checkNotNull(examProcess);
    }

    @GET
    public List<Exam> getSelectedQuestions() {
        return examProcess.getSelectedQuestions();
    }


    @POST
    public Exam createExam(Exam exam) {
        return this.examProcess.create(exam);
       /*if (question != null) {
           examPaperDAO.create(question);
           throw new WebApplicationException(Response.Status.OK);
       } else {
           throw new WebApplicationException(Response.Status.BAD_REQUEST);
       }*/
    }
    @GET
    @Path("/{exam_id}")
    public Exam getExamById(@PathParam("exam_id") int exam_id) {
        return examProcess.find(exam_id);
    }


    @PUT
    @Path("/{exam_id}")
    public Exam updateExam(@PathParam("exam_id") int exam_id, Exam exam){


        /*Question question= examPaperDAO.findQuestionById(question_id);
        question.setQuestion(updatedexamPaper.getQuestion());
        question.setFirstoption(updatedexamPaper.getFirstoption());
        question.setSecondoption(updatedexamPaper.getSecondoption());
        question.setThirdoption(updatedexamPaper.getThirdoption());
        question.setFourthoption(updatedexamPaper.getFourthoption());

        return examPaperDAO.update(question_id,question);*/
        return this.examProcess.update(exam_id, exam);
    }

    @DELETE
    @Path("/{exam_id}")
    public void deleteExam(@PathParam("exam_id") int exam_id) {
        this.examProcess.delete(exam_id);
    }

}
