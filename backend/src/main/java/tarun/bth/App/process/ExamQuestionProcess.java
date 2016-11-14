package tarun.bth.App.process;

import tarun.bth.App.db.entity.ExamQuestion;

import java.util.List;


public interface ExamQuestionProcess {
    int create(List<ExamQuestion> examQuestion);
    List<ExamQuestion> find(int exam_id);
}
