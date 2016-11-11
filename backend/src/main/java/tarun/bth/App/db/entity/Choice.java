package tarun.bth.App.db.entity;


public class Choice {
    private Integer id;

    private String choice;

    public Choice(Integer id, String choice) {
        this.id = id;
        this.choice = choice;
    }

    public Choice() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }
}
