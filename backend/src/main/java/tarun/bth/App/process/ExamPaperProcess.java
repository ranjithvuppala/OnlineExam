package tarun.bth.App.process;

import tarun.bth.App.db.entity.ExamPaper;

import javax.ws.rs.NotFoundException;
import java.util.List;

/**
 * Created by user on 03-11-2016.
 */
public interface ExamPaperProcess {
    List<ExamPaper> getAllQuestions();
    ExamPaper create(ExamPaper examPaper);
    ExamPaper update(Integer question_id, ExamPaper examPaper) throws NotFoundException;
    ExamPaper find(Integer question_id) throws NotFoundException;
    void delete(Integer question_id);
}
