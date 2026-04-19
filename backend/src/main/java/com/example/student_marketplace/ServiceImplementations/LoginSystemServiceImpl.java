package com.example.student_marketplace.ServiceImplementations;

import com.example.student_marketplace.Entities.LoginSystem;
import com.example.student_marketplace.Exceptions.IDNotFoundException;
import com.example.student_marketplace.Repositories.LoginSystemRepository;
import com.example.student_marketplace.Services.LoginSystemService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Consumer;

@Service
public class LoginSystemServiceImpl implements LoginSystemService{

    private final LoginSystemRepository loginSystemRepository;

    public LoginSystemServiceImpl(LoginSystemRepository loginSystemRepository) {
        this.loginSystemRepository = loginSystemRepository;
    }

    @Override
    public LoginSystem saveLoginSystem(LoginSystem loginSystem) {
        return loginSystemRepository.save(loginSystem);
    }

    @Override
    public List<LoginSystem> fetchAllLoginSystems() {
        return (List<LoginSystem>)loginSystemRepository.findAll();
    }

    @Override
    public LoginSystem updateLoginSystem(LoginSystem loginSystem, Long userID) {
        LoginSystem newLoginSystem = loginSystemRepository.findById(userID).orElseThrow(()-> new IDNotFoundException("User with " + userID + " not found"));

        checkThenUpdate(loginSystem.getUsername(), loginSystem::setUsername);
        checkThenUpdate(loginSystem.getPassword_hash(), (password) -> newLoginSystem.setPassword_hash(hashPassword(password)));

        return loginSystemRepository.save(newLoginSystem);
    }

    @Override
    public void deleteLoginSystem(Long userID) {
            loginSystemRepository.deleteById(userID);
    }

    private <T> void checkThenUpdate(T value, Consumer<T> setter){
        if (value != null){
            if (value instanceof String && ((String)value).isEmpty()){
                return;
            }

            setter.accept(value);
        }
    }

    private String hashPassword(String password){
        return password;
    }

}
