package tarun.bth.App.process;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import tarun.bth.App.db.entity.Email;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


public class EmailProcessImpl implements EmailProcess {

    @Override
    public Integer send(Email email) {
        System.out.println(email.getMessage());
        System.out.println(email.getTo());
        System.out.println(email.getSubject());
        ClientConfig clientConfig = new ClientConfig();
        Client client = ClientBuilder.newClient(clientConfig);
        client.register(HttpAuthenticationFeature.basic("api","key-99b661113697234d197484a70bd79678"));
        WebTarget webTarget = client.target("https://api.mailgun.net/v3/sandbox87c45377f9d348848291132368fd7e6a.mailgun.org/messages");

        Form formData = new Form();
        formData.param("from","postmaster@sandbox87c45377f9d348848291132368fd7e6a.mailgun.org");
        formData.param("to",email.getTo());
        formData.param("subject",email.getSubject());
        formData.param("text",email.getMessage());

        Response response = webTarget.request().post(Entity.entity(formData, MediaType.APPLICATION_FORM_URLENCODED_TYPE));

        System.out.println(response.toString());

        return response.getStatus();

    }
}
