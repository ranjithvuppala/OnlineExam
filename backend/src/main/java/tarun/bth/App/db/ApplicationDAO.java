package tarun.bth.App.db;


import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

@RegisterMapperFactory(BeanMapperFactory.class)
public interface ApplicationDAO {
    @SqlUpdate("CREATE TABLE IF NOT EXISTS application(exam_id int auto_increment primary key, exam_name varchar(12))")
    public void createTable();


}
