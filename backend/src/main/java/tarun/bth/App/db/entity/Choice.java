package tarun.bth.App.db.entity;


public class Choice {
    private Integer choice_id;

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
