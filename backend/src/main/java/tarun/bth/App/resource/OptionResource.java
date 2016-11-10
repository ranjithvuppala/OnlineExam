package tarun.bth.App.resource;

import tarun.bth.App.db.entity.Option;
import tarun.bth.App.process.OptionProcess;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;


@RolesAllowed("ADMIN")
@Path("Option")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OptionResource {
    private  OptionProcess optionProcess;

    public OptionResource(OptionProcess optionProcess) {
        this.optionProcess = checkNotNull(optionProcess);
    }

    @POST
    public Option createOption(Option option) {
        return this.optionProcess.create(option);
    }

        @GET
       // @Path("/onlyoptions/")
        public List<Option> getAllOptions() {
            return optionProcess.getAllOptions();
        }

}
