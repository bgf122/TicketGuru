package com.kineesio.TicketGuru.domain.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class LoginViewModel {

    @NotNull(message = "Käyttäjätunnus ei voi olla tyhjä")
    @Size(min = 4, max = 250, message = "Käyttäjänimen koko tulee olla 4 - 250 merkkiä")
    private String username;
    @NotNull(message = "Salasana ei voi olla tyhjä")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
