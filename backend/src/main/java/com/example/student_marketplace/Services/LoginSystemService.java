package com.example.student_marketplace.Services;

import com.example.student_marketplace.Entities.LoginSystem;

import java.util.List;

public interface LoginSystemService {

    LoginSystem saveLoginSystem(LoginSystem loginSystem);
    List<LoginSystem> fetchAllLoginSystems();
    LoginSystem updateLoginSystem(LoginSystem loginSystem, Long userID);
    void deleteLoginSystem(Long userID);
}
