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
    public List<QuestionChoice> create(QuestionChoice questionChoice) {

        return this.questionChoiceDAO.findQuestionChoiceById(this.questionChoiceDAO.create(questionChoice));
    }

    @Override
    public List<QuestionChoice> find(int question_id) {
        return this.questionChoiceDAO.findQuestionChoiceById(question_id);
    }
}

