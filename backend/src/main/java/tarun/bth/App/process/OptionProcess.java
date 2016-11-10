package tarun.bth.App.process;

import tarun.bth.App.db.entity.Option;

import javax.ws.rs.NotFoundException;
import java.util.List;

/**
 * Created by user on 03-11-2016.
 */
public interface OptionProcess {
    List<Option> getAllOptions();
    Option create(Option option);
    Option update(Integer option_id, Option option) throws NotFoundException;
    Option find(Integer option_id) throws NotFoundException;
    void delete(Integer option_id);

    //List<QuestionName> getOnlyQuestions();
}
