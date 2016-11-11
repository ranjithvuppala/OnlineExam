package tarun.bth.App.process;

import tarun.bth.App.db.QuestionChoiceDAO;
import tarun.bth.App.db.entity.QuestionChoice;

/**
 * Created by user on 11-11-2016.
 */
public class QuestionChoiceDbImpl implements QuestionChoiceProcess{
    private QuestionChoiceDAO questionChoiceDAO;

    public QuestionChoiceDbImpl(QuestionChoiceDAO questionChoiceDAO) {
        this.questionChoiceDAO= questionChoiceDAO;
    }

    @Override
    public QuestionChoice create(QuestionChoice questionChoice) {
            return this.questionChoiceDAO.findQuestionChoiceById(this.questionChoiceDAO.create(questionChoice));
        }

}

