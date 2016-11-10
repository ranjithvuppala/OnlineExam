package tarun.bth.App.resource;

import tarun.bth.App.db.entity.Option;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@RolesAllowed("ADMIN")
@Path("QuestionPaper")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OptionResource {
    @POST
    public Option createQuestion(Option option) {
        return this.optionProcess.create(option);

        @GET
        @Path("/onlyquestions/")
        public List<QuestionName> getOnlyQuestions() {
            return questionProcess.getOnlyQuestions();
        }

}
