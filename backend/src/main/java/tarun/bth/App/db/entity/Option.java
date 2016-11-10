package tarun.bth.App.db.entity;

/**
 * Created by user on 10-11-2016.
 */
public class Option {
    private Integer option_id;

    private String option;

    public Option(Integer option_id, String option) {
        this.option_id = option_id;
        this.option = option;
    }

    public Option() {
    }

    public Integer getOption_id() {
        return option_id;
    }

    public void setOption_id(Integer option_id) {
        this.option_id = option_id;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }
}
