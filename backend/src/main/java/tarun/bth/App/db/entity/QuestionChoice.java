package tarun.bth.App.db.entity;


public class QuestionChoice {

    private Integer question_id;

    private Integer choice_id;

    public QuestionChoice() {
    }

    public QuestionChoice(Integer question_id, Integer choice_id) {
        this.question_id = question_id;
        this.choice_id = choice_id;
    }

    public Integer getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Integer question_id) {
        this.question_id = question_id;
    }

    public Integer getChoice_id() {
        return choice_id;
    }

    public void setChoice_id(Integer choice_id) {
        this.choice_id = choice_id;
    }
}
