package tarun.bth.App.db.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class Choice {
    @JsonProperty
    private Integer choice_id;

    @JsonProperty
    @NotEmpty
    @Length(max=100, message="Choice must not be longer than 100 characters")
    private String choice;

    public Choice(Integer choice_id, String choice) {
        this.choice_id = choice_id;
        this.choice = choice;
    }

    public Choice() {
    }

    public Integer getChoice_id() {
        return choice_id;
    }

    public void setChoice_id(Integer choice_id) {
        this.choice_id = choice_id;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }
}
