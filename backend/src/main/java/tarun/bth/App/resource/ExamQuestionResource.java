package tarun.bth.App.resource;

import tarun.bth.App.db.entity.ExamQuestion;
import tarun.bth.App.process.ExamQuestionProcess;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

@RolesAllowed("ADMIN")
@Path("ExamQuestion")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ExamQuestionResource {

    private ExamQuestionProcess examQuestionProcess;

    public ExamQuestionResource(ExamQuestionProcess examQuestionProcess) {
        this.examQuestionProcess = checkNotNull(examQuestionProcess);
    }

    @POST
    public int createQuestionChoice(List<ExamQuestion> examQuestion) {
        return this.examQuestionProcess.create(examQuestion);
    }


}
