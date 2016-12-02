package tarun.bth.App.process;


import tarun.bth.App.db.ExamDAO;
import tarun.bth.App.db.ExamQuestionDAO;
import tarun.bth.App.db.QuestionDAO;
import tarun.bth.App.db.entity.Exam;
import tarun.bth.App.db.entity.ExamResponse;
import tarun.bth.App.db.entity.QuestionResponse;

import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class ExamProcessDbImpl implements ExamProcess {

    private ExamDAO examDAO;
    private ExamQuestionDAO examQuestionDAO;
    private QuestionProcess questionProcess;

    public ExamProcessDbImpl(ExamDAO examDAO, ExamQuestionDAO examQuestionDAO, QuestionProcess questionProcess) {
        this.examDAO = examDAO;
        this.examQuestionDAO= examQuestionDAO;
        this.questionProcess=questionProcess;
    }


    @Override
    public List<Exam> getExams() {return examDAO.getExams(); }

    @Override
    public Exam create(Exam exam) {
        return this.examDAO.findExamById(this.examDAO.create(exam));
    }



    @Override
    public Exam update(Integer exam_id, Exam updatedExamPaper) throws NotFoundException {
        Exam exam = this.find(exam_id);
        exam.setExam(updatedExamPaper.getExam());
        this.examDAO.update(exam);
        return exam;
    }

    @Override
    public Exam find(Integer id) throws NotFoundException {
        return Optional
                .ofNullable(this.examDAO.findExamById(id))
                .orElseThrow(() -> new NotFoundException("Exam does not exist"));
    }

    @Override
    public void delete(Integer exam_id) {
        this.examDAO.delete(exam_id);
        this.examQuestionDAO.deleteByExamId(exam_id);
    }

    @Override
    public ExamResponse findExamById(Integer exam_id) {
        List<Integer> questionIdList = this.examQuestionDAO.findExamQuestionById(exam_id);
        List<QuestionResponse> questionResponseList = this.questionProcess.findList(questionIdList);
        Exam exam= this.find(exam_id);
        ExamResponse examResponse = new ExamResponse(exam,questionResponseList);
        examResponse.setExam(exam);
        examResponse.setQuestionResponseList(questionResponseList);

        return examResponse;
    }

    @Override
    public List<ExamResponse> getAllExams() {
        List<Exam> examList = this.getExams();
        List<ExamResponse> examResponseList = new ArrayList<ExamResponse>();
        for(Exam i:examList){
            ExamResponse examResponse = this.findExamById(i.getExam_id());
            examResponseList.add(examResponse);
        }
        return examResponseList;
    }
}
