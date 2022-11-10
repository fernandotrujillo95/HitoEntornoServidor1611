package com.example.hitoentornoservidor;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class Login {
    private Usuario login;

    public Login() {
        this.login = null;
        // Sin inicio de sesión por el momento.
    }

    public Usuario getLogin() {
        return login;
    }

    public void setLogin(Usuario login) {
        this.login = login;
    }
}
