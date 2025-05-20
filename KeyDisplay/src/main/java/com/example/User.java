package com.example;

public class User {
    private String firstname, lastname, username, gmail, password, dob;

    public User(String fn, String ln, String un, String gm, String pw, String dob) {
        this.firstname = fn;
        this.lastname = ln;
        this.username = un;
        this.gmail = gm;
        this.password = pw;
        this.dob = dob;
    }

    public String getFirstname() { return firstname; }
    public String getPassword() { return password; }
    public String getDob() { return dob; }
}
