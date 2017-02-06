package org.mativil.dto;

/**
 * Created by Ivan on 05.02.2017.
 */
public class UserRegistrationDTO {
    private String login;
    private String password;
    private String confrimation;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfrimation() {
        return confrimation;
    }

    public void setConfrimation(String confrimation) {
        this.confrimation = confrimation;
    }

    public UserRegistrationDTO() {
    }
}
