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
import tarun.bth.App.db.ApplicationDAO;
import tarun.bth.App.db.ExamPaperDAO;
import tarun.bth.App.db.LoginDAO;
import tarun.bth.App.db.entity.Login;
import tarun.bth.App.process.ExamPaperProcess;
import tarun.bth.App.process.ExamPaperProcessDbImpl;
import tarun.bth.App.process.LoginProcess;
import tarun.bth.App.process.LoginProcessDbImpl;
import tarun.bth.App.resource.ExamPaperResource;
import tarun.bth.App.resource.LoginResource;


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
        final LoginDAO loginDAO = dbi.onDemand(LoginDAO.class);
        final ExamPaperDAO examPaperDAO = dbi.onDemand(ExamPaperDAO.class);

        // processes
        ExamPaperProcess examPaperProcess = new ExamPaperProcessDbImpl(examPaperDAO);

        LoginProcess loginProcess = new LoginProcessDbImpl(loginDAO);
        environment.jersey().register(new LoginResource(loginProcess));


        // resources
        //LoginResource loginResource = new LoginResource()
        ExamPaperResource examPaperResource = new ExamPaperResource(examPaperProcess);

        // tables
        loginDAO.createTable();
        examPaperDAO.createTable();



        environment.jersey().register(examPaperResource);

        //insert admin into table login
       // loginDAO.insertAdminDetails();

        //Processses
        //insert admin into table login
        // loginDAO.insertAdminDetails();


       //Authentication and Authorization
        environment.jersey().register(new AuthDynamicFeature(
                new BasicCredentialAuthFilter.Builder<Login>()
                        .setAuthenticator(new ExamAuthenticator(loginProcess))
                        .setAuthorizer(new ExamAuthorizer(loginProcess))
                        .setRealm("SUPER SECRET STUFF")
                        .buildAuthFilter()));
        environment.jersey().register(RolesAllowedDynamicFeature.class);
        //If you want to use @Auth to inject a custom Principal type into your resource
        environment.jersey().register(new AuthValueFactoryProvider.Binder<>(Login.class));

    }
    @Override
    public void initialize(Bootstrap<ApplicationConfiguration> configuration) {
        configuration.addBundle(new ConfiguredAssetsBundle("/assets/", "/", "index.html"));
    }
    public static void main(String[] args) throws Exception{
        new App().run(args);
    }
}
