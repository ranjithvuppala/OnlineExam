package tarun.bth.App.db.entity;



public class Question {

    private Integer question_id;


    private String question;


    private String firstoption;


    private String secondoption;


    private String thirdoption;


    private String fourthoption;

    private String correctoption;

    public Question(){}

    public Question(Integer question_id, String question, String firstoption, String secondoption, String thirdoption, String fourthoption){

        this.question_id=question_id;
        this.question=question;
        this.firstoption=firstoption;
        this.secondoption=secondoption;
        this.thirdoption=thirdoption;
        this.fourthoption=fourthoption;
    }
    public Integer getQuestion_id() {
        return question_id;
    }

    public String getQuestion() {
        return question;
    }

    public String getFirstoption() { return firstoption;}

    public String getSecondoption() { return secondoption;}

    public String getThirdoption() { return thirdoption;}

    public String getFourthoption() { return fourthoption;}

    public void setQuestion_id(Integer question_id) {
        this.question_id = question_id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setFirstoption(String firstoption) { this.firstoption = firstoption;}

    public void setSecondoption(String secondoption) { this.secondoption = secondoption;}

    public void setThirdoption(String thirdoption) { this.thirdoption = thirdoption;}

    public void setFourthoption(String fourthoption) { this.fourthoption = fourthoption;}
}
