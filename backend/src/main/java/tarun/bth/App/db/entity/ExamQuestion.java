package tarun.bth.App.db.entity;

public class ExamQuestion {

    private Integer exam_id;
    private Integer question_id;

    public ExamQuestion() {
    }

    public ExamQuestion(Integer exam_id, Integer question_id) {
        this.exam_id = exam_id;
        this.question_id = question_id;
    }

    public Integer getExam_id() {
        return exam_id;
    }

    public void setExam_id(Integer exam_id) {
        this.exam_id = exam_id;
    }

    public Integer getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Integer question_id) {
        this.question_id = question_id;
    }
}
