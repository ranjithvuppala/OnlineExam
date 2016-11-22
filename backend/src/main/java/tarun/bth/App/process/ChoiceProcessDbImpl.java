package tarun.bth.App.process;

import tarun.bth.App.db.ChoiceDAO;
import tarun.bth.App.db.QuestionChoiceDAO;
import tarun.bth.App.db.QuestionDAO;
import tarun.bth.App.db.entity.Choice;


import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class ChoiceProcessDbImpl implements ChoiceProcess {

    private ChoiceDAO choiceDAO;

    private QuestionChoiceDAO questionChoiceDAO;

    private QuestionDAO questionDAO;

    private QuestionProcess questionProcess;

    public ChoiceProcessDbImpl(ChoiceDAO choiceDAO, QuestionChoiceDAO questionChoiceDAO, QuestionDAO questionDAO, QuestionProcess questionProcess) {
        this.choiceDAO = choiceDAO;
        this.questionChoiceDAO = questionChoiceDAO;
        this.questionDAO  = questionDAO;
        this.questionProcess = questionProcess;
    }

    @Override
    public List<Choice> getAllChoices() {
        return choiceDAO.getAllChoices() ;
    }


    @Override
    public Choice create(Choice choice) {
        return this.choiceDAO.findChoiceById(this.choiceDAO.create(choice));
    }

    @Override
    public Choice update(Integer choice_id, Choice updatedexamPaper) throws NotFoundException {
        Choice choice = this.find(choice_id);
        choice.setChoice(updatedexamPaper.getChoice());

        this.choiceDAO.update(choice);
        return choice;
    }

    @Override
    public Choice find(Integer choice_id) throws NotFoundException {
        return (Choice) Optional
                .ofNullable(this.choiceDAO.findChoiceById(choice_id))
                .orElseThrow(() -> new NotFoundException("ChoiceName does not exist"));
    }

    @Override
    public void delete(Integer choice_id) {
        this.choiceDAO.delete(choice_id);
        this.questionChoiceDAO.deleteByChoiceId(choice_id);
        List<Integer> questionIdList = this.questionDAO.findByCorrectChoiceId(choice_id);

        for (Integer i:questionIdList){
            this.questionProcess.delete(i);
        }
    }

}
