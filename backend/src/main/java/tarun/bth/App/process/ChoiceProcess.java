package tarun.bth.App.process;

import tarun.bth.App.db.entity.Choice;

import javax.ws.rs.NotFoundException;
import java.util.List;


public interface ChoiceProcess {
    List<Choice> getAllChoices();
    Choice create(Choice choice);
    Choice update(Integer choice_id, Choice choice) throws NotFoundException;
    Choice find(Integer choice_id) throws NotFoundException;
    void delete(Integer choice_id);

}
