package tarun.bth.App.db.entity;



public class Exam {

    private Integer exam_id;

    private String exam;

    public Exam(){}

    public Exam(Integer exam_id,String exam){

        this.exam_id=exam_id;
        this.exam=exam;
    }

    public Exam(String exam){
        this.exam = exam;
    }


    public Integer getExam_id() {
        return exam_id;
    }

    public String getExam() {return exam;}


    public void setExam_id(Integer exam_id) {
        this.exam_id = exam_id;
    }

    public void setExam(String exam) {this.exam = exam;}

}
