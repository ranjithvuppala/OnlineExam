package tarun.bth.App.db.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class Question {

    @JsonProperty
    private Integer question_id;

    @JsonProperty
    @NotEmpty
    @Length(max=255,message="must not be longer than 255 characters")
    private String question;

    @JsonProperty
    private Integer correctChoice_id;

    public Question(){}

    public Question(Integer question_id, String question, Integer correctChoice_id){

        this.question_id=question_id;
        this.question=question;
        this.correctChoice_id = correctChoice_id;

    }

    public Question(String question, Integer correctChoice_id){
        this.question = question;
        this.correctChoice_id = correctChoice_id;
    }

    public Question(Integer question_id, String question){
        this.question_id = question_id;
        this.question = question;
    }

    public Question(Integer question_id, Integer correctChoice_id){
        this.question_id = question_id;
        this.correctChoice_id = correctChoice_id;
    }

    public Question(String question){
        this.question = question;

    }

    public Integer getQuestion_id() {
        return question_id;
    }

    public String getQuestion() {
        return question;
    }

    public Integer getCorrectChoice_id() {
        return correctChoice_id;
    }

    public void setQuestion_id(Integer question_id) {
        this.question_id = question_id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setCorrectChoice_id(Integer correctChoice_id) {
        this.correctChoice_id = correctChoice_id;
    }
}
