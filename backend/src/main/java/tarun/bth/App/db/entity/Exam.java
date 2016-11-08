package tarun.bth.App.db.entity;



public class Exam {

    private Integer exam_id;

   // private String exam;

    private Integer firstquestion_id;

    private Integer secondquestion_id;

    private Integer thirdquestion_id;

    private Integer fourthquestion_id;

    private Integer fifthquestion_id;

    public Exam(){}

    public Exam(Integer exam_id, Integer firstquestion_id, Integer secondquestion_id, Integer thirdquestion_id, Integer fourthquestion_id, Integer fifthquestion_id){

        this.exam_id=exam_id;
        //this.exam=exam;
        this.firstquestion_id=firstquestion_id;
        this.secondquestion_id=secondquestion_id;
        this.thirdquestion_id=thirdquestion_id;
        this.fourthquestion_id=fourthquestion_id;
        this.fifthquestion_id=fifthquestion_id;
    }
    public Integer getExam_id() {
        return exam_id;
    }
    public Integer getFirstquestion_id() { return firstquestion_id;}
    public Integer getSecondquestion_id() { return secondquestion_id;}
    public Integer getThirdquestion_id() { return thirdquestion_id;}
    public Integer getFourthquestion_id() { return fourthquestion_id;}
    public Integer getFifthquestion_id() { return fifthquestion_id;}

   // public String getExamPaper() {return exam;}


    public void setExam_id(Integer exam_id) {
        this.exam_id = exam_id;
    }

   // public void setQuestion(String question) {this.question = question;}

    public void setFirstquestion_id(Integer firstquestion_id) { this.firstquestion_id = firstquestion_id;}

    public void setSecondquestion_id(Integer secondquestion_id) { this.secondquestion_id = secondquestion_id;}

    public void setThirdquestion_id(Integer thirdquestion_id) { this.thirdquestion_id = thirdquestion_id;}

    public void setFourthquestion_id(Integer fourthquestion_id) { this.fourthquestion_id = fourthquestion_id;}

    public void setFifthquestion_id(Integer fifthquestion_id) { this.fifthquestion_id = fifthquestion_id;}

}
