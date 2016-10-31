package tarun.bth.App.db.entity;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Login {
    @JsonProperty
    public Integer id;

    @JsonProperty
    public String username;

    @JsonProperty
    public String password;

    public Login(){}

    public Login(int id, String username, String password){

        this.id=id;
        this.username=username;
        this.password=password;
    }
    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() { return password;}

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) { this.password = password;}

    @Override
    public String toString() {
        return "Login{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
