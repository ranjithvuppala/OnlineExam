package tarun.bth.App;

import com.bazaarvoice.dropwizard.assets.ConfiguredAssetsBundle;
import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.h2.tools.Server;
import org.skife.jdbi.v2.DBI;
import tarun.bth.App.auth.ExamAuthenticator;
import tarun.bth.App.auth.ExamAuthorizer;
import tarun.bth.App.db.QuestionDAO;
import tarun.bth.App.db.UserDAO;
import tarun.bth.App.db.entity.User;
import tarun.bth.App.process.QuestionProcess;
import tarun.bth.App.process.QuestionProcessDbImpl;
import tarun.bth.App.process.UserProcess;
import tarun.bth.App.process.UserProcessDbImpl;
import tarun.bth.App.resource.QuestionResource;
import tarun.bth.App.resource.UserResource;


public class App extends Application<ApplicationConfiguration>{
    @Override
    public void run(ApplicationConfiguration configuration, Environment environment) throws Exception {
        final Server h2db = Server.createWebServer("-webDaemon");
        final DBIFactory factory = new DBIFactory();
        final DBI dbi = factory.build(environment, configuration.getDataSourceFactory(), "h2");
        environment.jersey().setUrlPattern("/api/*");
        // h2
        h2db.start();

        // data access objects
        final UserDAO userDAO = dbi.onDemand(UserDAO.class);
        final QuestionDAO questionDAO = dbi.onDemand(QuestionDAO.class);

        // processes
        QuestionProcess questionProcess = new QuestionProcessDbImpl(questionDAO);

        UserProcess userProcess = new UserProcessDbImpl(userDAO);



        // resources
        //UserResource loginResource = new UserResource()
        QuestionResource questionResource = new QuestionResource(questionProcess);

        // tables
        userDAO.createTable();
        questionDAO.createTable();

        //insert admin into table login
         userDAO.insertAdminDetails();


        //Resource registration
        environment.jersey().register(questionResource);
        environment.jersey().register(new UserResource(userProcess));



        //Authentication and Authorization
        environment.jersey().register(new AuthDynamicFeature(
                new BasicCredentialAuthFilter.Builder<User>()
                        .setAuthenticator(new ExamAuthenticator(userProcess))
                        .setAuthorizer(new ExamAuthorizer(userProcess))
                        .setRealm("SUPER SECRET STUFF")
                        .buildAuthFilter()));
        environment.jersey().register(RolesAllowedDynamicFeature.class);
        //If you want to use @Auth to inject a custom Principal type into your resource
        environment.jersey().register(new AuthValueFactoryProvider.Binder<>(User.class));
    }

    @Override
    public void initialize(Bootstrap<ApplicationConfiguration> configuration) {
        configuration.addBundle(new ConfiguredAssetsBundle("/assets/", "/", "index.html"));
    }
    public static void main(String[] args) throws Exception{
        new App().run(args);
    }


}
