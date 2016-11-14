package tarun.bth.App.process;

import tarun.bth.App.db.QuestionChoiceDAO;
import tarun.bth.App.db.entity.QuestionChoice;
import java.util.List;

public class QuestionChoiceDbImpl implements QuestionChoiceProcess{
    private QuestionChoiceDAO questionChoiceDAO;

    public QuestionChoiceDbImpl(QuestionChoiceDAO questionChoiceDAO) {
        this.questionChoiceDAO= questionChoiceDAO;
    }

    @Override
    public int create(List<QuestionChoice> questionChoice){

        for(QuestionChoice i : questionChoice){

            this.questionChoiceDAO.create(i);

        }

        return(0);
    }

    @Override
    public List<QuestionChoice> find(int question_id) {
        return this.questionChoiceDAO.findQuestionChoiceById(question_id);
    }
}

