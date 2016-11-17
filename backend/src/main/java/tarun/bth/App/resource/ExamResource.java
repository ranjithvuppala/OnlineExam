package tarun.bth.App.resource;

import tarun.bth.App.db.entity.Exam;
import tarun.bth.App.db.entity.ExamResponse;
import tarun.bth.App.db.entity.QuestionResponse;
import tarun.bth.App.process.ExamProcess;
import tarun.bth.App.process.ExamQuestionProcess;
import tarun.bth.App.process.QuestionProcess;

import javax.annotation.security.PermitAll;
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

    private QuestionProcess questionProcess;

    private ExamQuestionProcess examQuestionProcess;

    public ExamResource(ExamProcess examProcess, QuestionProcess questionProcess, ExamQuestionProcess examQuestionProcess) {
        this.examProcess = checkNotNull(examProcess);
        this.questionProcess = checkNotNull(questionProcess);
        this.examQuestionProcess = checkNotNull(examQuestionProcess);
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
    @PermitAll
    @Path("/{exam_id}")
    public ExamResponse getExamById(@PathParam("exam_id") int exam_id) {
        List<Integer> questionIdList = this.examQuestionProcess.find(exam_id);
        List<QuestionResponse> questionResponseList = this.questionProcess.findList(questionIdList);
        Exam exam= this.examProcess.find(exam_id);
        ExamResponse examResponse = new ExamResponse(exam,questionResponseList);
        examResponse.setExam(exam);
        examResponse.setQuestionResponseList(questionResponseList);

        return examResponse;
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
