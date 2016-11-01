package tarun.bth.App.resource;

import com.google.common.base.Preconditions;
import tarun.bth.App.db.LoginDAO;
import tarun.bth.App.db.entity.Login;
import tarun.bth.App.db.entity.LoginResult;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


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
    public int createLogin(@NotNull Login login) {
       return this.loginDAO.create(login);
       /* if (login != null) {
            loginDAO.create(login);
            throw new WebApplicationException(Response.Status.OK);
        } else {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }*/
    }

   @GET
   @Path("/{id}")
   public Login getLoginById(@PathParam("id") int id) {
           return loginDAO.findUserById(id);
        }

   // @GET
   // @Path("/{username}/{password}")
   // public Login getLoginByUsername(@PathParam("username") String username, @PathParam("password") String password) {
   //    return loginDAO.findUserByUsername(username,password);
   // }
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

    @PUT
    @Path("/{id}")
    public int updateLogin(@PathParam("id") Integer id, Login updatedlogin){
       Login login=loginDAO.findUserById(id);
        login.setUsername(updatedlogin.getUsername());
        login.setPassword(updatedlogin.getPassword());
        return loginDAO.update(login);
    }
   /* @GET
    public String getWords(){
        return "Hello World,";
    }
*/



}
