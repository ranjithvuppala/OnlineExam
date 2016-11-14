package tarun.bth.App.resource;

import tarun.bth.App.db.entity.ExamQuestion;
import tarun.bth.App.process.ExamQuestionProcess;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import static com.google.common.base.Preconditions.checkNotNull;

@Path("ExamQuestion")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ExamQuestionResource {

    private ExamQuestionProcess examQuestionProcess;

    public ExamQuestionResource(ExamQuestionProcess examQuestionProcess) {
        this.examQuestionProcess = checkNotNull(examQuestionProcess);
    }

    @POST
    public ExamQuestion createQuestionChoice(ExamQuestion examQuestion) {
        return this.examQuestionProcess.create(examQuestion);
    }


}
