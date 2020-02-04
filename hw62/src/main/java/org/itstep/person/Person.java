package org.itstep.person;

public class Person {
    private String login;
    private String password;
    private String status;

    public Person(String login, String password, String status) {
        this.login = login;
        this.password = password;
        this.status = status;
    }

    public String getLogin() {
        return login;
    }

    public String getStatus() {
        return status;
    }

    public String getPassword() {
        return password;
    }
}
