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
import tarun.bth.App.db.*;
import tarun.bth.App.db.entity.User;
import tarun.bth.App.process.*;
import tarun.bth.App.resource.*;


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
        final ExamDAO examDAO = dbi.onDemand(ExamDAO.class);
        final ChoiceDAO choiceDAO = dbi.onDemand(ChoiceDAO.class);
        final QuestionChoiceDAO questionChoiceDAO=dbi.onDemand(QuestionChoiceDAO.class);
        final ExamQuestionDAO examQuestionDAO=dbi.onDemand(ExamQuestionDAO.class);

        // processes
        UserProcess userProcess = new UserProcessDbImpl(userDAO);
        ExamProcess examProcess = new ExamProcessDbImpl(examDAO);
        ChoiceProcess choiceProcess = new ChoiceProcessDbImpl(choiceDAO);
        QuestionChoiceProcess questionChoiceProcess = new QuestionChoiceDbImpl(questionChoiceDAO);
        ExamQuestionProcess examQuestionProcess = new ExamQuestionDbImpl(examQuestionDAO);
        QuestionProcess questionProcess = new QuestionProcessDbImpl(questionDAO,questionChoiceProcess,choiceProcess);

        // resources
        //UserResource loginResource = new UserResource()
        QuestionResource questionResource = new QuestionResource(questionProcess,questionChoiceProcess,choiceProcess);
        ExamResource examResource = new ExamResource(examProcess,questionProcess,examQuestionProcess);
        ChoiceResource choiceResource = new ChoiceResource(choiceProcess);
        QuestionChoiceResource questionChoiceResource = new QuestionChoiceResource(questionChoiceProcess);
        ExamQuestionResource examQuestionResource = new ExamQuestionResource(examQuestionProcess);


        // tables
        userDAO.createTable();
        questionDAO.createTable();
        examDAO.createTable();
        choiceDAO.createTable();
        questionChoiceDAO.createTable();
        examQuestionDAO.createTable();

        //insert admin into table login
         userDAO.insertAdminDetails();


        //Resource registration
        environment.jersey().register(questionResource);
        environment.jersey().register(new UserResource(userProcess));
        environment.jersey().register(examResource);
        environment.jersey().register(choiceResource);
        environment.jersey().register(questionChoiceResource);
        environment.jersey().register(examQuestionResource);


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
