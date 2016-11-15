package tarun.bth.App.resource;

import tarun.bth.App.db.entity.Exam;
import tarun.bth.App.process.ExamProcess;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

@RolesAllowed("ADMIN")
@Path("Exam")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ExamResource {
    private ExamProcess examProcess;

    public ExamResource(ExamProcess examProcess) {
        this.examProcess = checkNotNull(examProcess);
    }

    @GET
    public List<Exam> getExam(){
        return this.examProcess.getExams();
    }

    @POST
    public Exam create(Exam exam) {
        return this.examProcess.create(exam);
    }
    @GET
    @Path("/{exam_id}")
    public Exam getExamById(@PathParam("exam_id") int exam_id) {
        return this.examProcess.find(exam_id);
    }


    @PUT
    @Path("/{exam_id}")
    public Exam updateExam(@PathParam("exam_id") int exam_id, Exam exam){
        return this.examProcess.update(exam_id, exam);
    }

    @DELETE
    @Path("/{exam_id}")
    public void deleteExam(@PathParam("exam_id") int exam_id) {
        this.examProcess.delete(exam_id);
    }

}
