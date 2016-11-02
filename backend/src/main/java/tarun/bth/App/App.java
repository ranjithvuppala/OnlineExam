package tarun.bth.App;

import com.bazaarvoice.dropwizard.assets.ConfiguredAssetsBundle;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.h2.tools.Server;
import org.skife.jdbi.v2.DBI;
import tarun.bth.App.db.ApplicationDAO;
import tarun.bth.App.db.ExamPaperDAO;
import tarun.bth.App.db.LoginDAO;
import tarun.bth.App.db.entity.ExamPaper;
import tarun.bth.App.db.entity.Login;
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
        final ApplicationDAO applicationDAO = dbi.onDemand(ApplicationDAO.class);
        final LoginDAO loginDAO = dbi.onDemand(LoginDAO.class);
        final ExamPaperDAO examPaperDAO = dbi.onDemand(ExamPaperDAO.class);
        // tables
        applicationDAO.createTable();
        loginDAO.createTable();
        examPaperDAO.createTable();


        environment.jersey().register(new LoginResource(loginDAO));
        environment.jersey().register(new ExamPaperResource(examPaperDAO));
        //insert admin into table login
        // loginDAO.insertAdminDetails();
    }

    @Override
    public void initialize(Bootstrap<ApplicationConfiguration> configuration){
        configuration.addBundle(new ConfiguredAssetsBundle("/assets/","/","index.html"));
    }


    public static void main(String[] args) throws Exception{
        new App().run(args);
    }

}
