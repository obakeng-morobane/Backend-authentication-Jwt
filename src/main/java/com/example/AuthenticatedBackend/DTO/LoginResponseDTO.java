package com.example.AuthenticatedBackend.DTO;

import com.example.AuthenticatedBackend.models.User;

public class LoginResponseDTO {
    private User user;
    private String jwt;

    public LoginResponseDTO(){
        super();
    }

    public LoginResponseDTO(User user, String jwt){
        this.user = user;
        this.jwt = jwt;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getJwt() {
        return this.jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
