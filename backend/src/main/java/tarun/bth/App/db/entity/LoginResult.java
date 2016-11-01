package tarun.bth.App.db.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by user on 27-10-2016.
 */
public class LoginResult {

    @JsonProperty
    private String result;

    public LoginResult(){}

    public LoginResult( String result){

        this.result=result;
    }
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
