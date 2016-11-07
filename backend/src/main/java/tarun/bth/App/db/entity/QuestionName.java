package tarun.bth.App.db.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

public class QuestionName {

    private Integer question_id;


    private String question;

    public QuestionName() {
    }

    public QuestionName(Integer question_id, String question) {
        this.question_id = question_id;
        this.question = question;
    }

    public Integer getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Integer question_id) {
        this.question_id = question_id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}