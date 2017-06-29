package model;

/**
 * Created by sushant on 6/29/17.
 */

public class User {

    String username, fullname, about, password;
    int id;

    public User() {
    }

    public User(int id, String username, String fullname, String about, String password) {
        this.id = id;
        this.username = username;
        this.fullname = fullname;
        this.about = about;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}


