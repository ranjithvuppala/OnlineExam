package tarun.bth.App.resource;

import com.google.common.base.Preconditions;
import org.eclipse.jetty.server.Response;
import tarun.bth.App.db.LoginDAO;
import tarun.bth.App.db.entity.Login;
import tarun.bth.App.db.entity.LoginResult;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by user on 26-10-2016.
 */
@Path("login")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoginResource {
    //private LoginProcess loginProcess;
    private LoginDAO loginDAO;
    public LoginResource(LoginDAO loginDAO) {
        Preconditions.checkNotNull(loginDAO);
        this.loginDAO = loginDAO;
    }
    @GET
    @Path("/all/")
    public List<Login> getAllLogin() {
        return loginDAO.getAllLogin();
    }

    @POST
    public int createLogin(Login login) {
        Login test1 = loginDAO.findUserByUsername(login.username,login.password);
        if(test1 != null) {
            //String result1 = "login successful";
            //LoginResult res1= new LoginResult("success");
            //return Response.SC_OK;
            throw new WebApplicationException(200);
            //return res1;
        }

        else{
             //LoginResult result = "login failure";
            //return Response.SC_NO_CONTENT;
            throw new WebApplicationException(401);
            //LoginResult res= new LoginResult("failure");
            //return res;
        }


    }

   @GET
   @Path("/{id}")
   public Login getLoginById(@PathParam("id") Integer id) {
           return loginDAO.findUserById(id);
        }

    /*
    @GET
    @Path("/{username}/{password}")
    public Login getLoginByUsername(@PathParam("username") String username, @PathParam("password") String password) {
       return loginDAO.findUserByUsername(username,password);
    }
    */
    /*
    @GET
    @Path("/{username}/{password}")
    public LoginResult getLoginByUsername(@PathParam("username") String username, @PathParam("password") String password) {
        Login test= loginDAO.findUserByUsername(username,password);

        if(test != null) {
            String result = "login successful";
            LoginResult res= new LoginResult("sucess");
            //return Response.status(200).entity(result).build();
            return res;
        }
        else{
            //String result = "login failure";
            //return Response.ok(result).build();
            //throw new WebApplicationException(404);
            LoginResult res= new LoginResult("failure");
            return res;
        }
    }
    */
    @GET
    public String getWords(){
        return "Hello World,";
    }

}
