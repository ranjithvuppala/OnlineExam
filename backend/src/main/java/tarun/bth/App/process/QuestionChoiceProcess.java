package tarun.bth.App.process;

import tarun.bth.App.db.entity.QuestionChoice;

import java.util.List;

public interface QuestionChoiceProcess {
    List<QuestionChoice> create(QuestionChoice questionChoice);
    List<QuestionChoice> find(int question_id);


}
