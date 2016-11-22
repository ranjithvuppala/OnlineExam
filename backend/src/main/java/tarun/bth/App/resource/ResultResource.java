package tarun.bth.App.resource;

import tarun.bth.App.db.entity.Question;
import tarun.bth.App.process.QuestionProcess;

import javax.annotation.security.PermitAll;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@PermitAll
@Path("Result")

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ResultResource {
    public List<Question> questions;

    public QuestionProcess questionProcess;

    public ResultResource() {
    }

    public ResultResource(QuestionProcess questionProcess) {
        this.questionProcess = questionProcess;
    }

    @POST
    public int answerSubmitted(List<Question> questions){
        int result=0;
        List<Integer> submittedChoices = new ArrayList<Integer>();
        List<Integer> correctChoice= new ArrayList<Integer>();
        for (Question i: questions ){
            int getCorrectChoice= questionProcess.findChoice(i.getQuestion_id());
            correctChoice.add(getCorrectChoice);
            submittedChoices.add(i.getCorrectChoice_id());
            if(getCorrectChoice==i.getCorrectChoice_id()){
                result++;
            }
            }
        return result;

    }
}
