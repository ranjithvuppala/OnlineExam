package tarun.bth.App.db.entity;


import java.util.List;

public class ExamResponse {

    private Exam exam;

    private List<QuestionResponse> questionResponseList;

    public ExamResponse(){}

    public ExamResponse(Exam exam, List<QuestionResponse> questionResponseList){

        this.exam = exam;
        this.questionResponseList = questionResponseList;
    }


    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public List<QuestionResponse> getQuestionResponseList() {
        return questionResponseList;
    }

    public void setQuestionResponseList(List<QuestionResponse> questionResponseList) {
        this.questionResponseList = questionResponseList;
    }
}



