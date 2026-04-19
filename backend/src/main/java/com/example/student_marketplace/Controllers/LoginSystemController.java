package com.example.student_marketplace.Controllers;

import com.example.student_marketplace.Entities.LoginSystem;
import com.example.student_marketplace.Services.LoginSystemService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoginSystemController {
    private final LoginSystemService loginSystemService;

    public LoginSystemController(LoginSystemService loginSystemService) {
        this.loginSystemService = loginSystemService;
    }


    @PostMapping("/loginSystem")
    public LoginSystem saveLoginSystem(@Valid @RequestBody LoginSystem loginSystem) {
        return loginSystemService.saveLoginSystem(loginSystem);
    }

    @GetMapping("/loginSystem")
    public List<LoginSystem> fetchAllLoginSystems() {
        return loginSystemService.fetchAllLoginSystems();
    }

    @PutMapping("/loginSystem/{id}")
    public LoginSystem updateLoginSystem(@RequestBody LoginSystem loginSystem, @PathVariable("id") Long userID) {
        return loginSystemService.updateLoginSystem(loginSystem, userID);
    }

    @DeleteMapping("/loginSystem/{id}")
    public String deleteLoginSystem(@PathVariable("id") Long userID) {
        loginSystemService.deleteLoginSystem(userID);

        return "Succesfully deleted user with ID " + userID;
    }
}
