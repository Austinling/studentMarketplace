package com.austin.student_marketplace.auth.service.impl;

import com.austin.student_marketplace.Exceptions.AuthException;
import com.austin.student_marketplace.auth.AuthRepository;
import com.austin.student_marketplace.auth.Profile;
import com.austin.student_marketplace.auth.RegisterRequest;
import com.austin.student_marketplace.auth.User;
import com.austin.student_marketplace.auth.dto.LoginRequestDto;
import com.austin.student_marketplace.auth.dto.VerifyRequestDto;
import com.austin.student_marketplace.auth.service.AuthRequestService;
import com.austin.student_marketplace.listings.ListingRepository;
import jakarta.mail.MessagingException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;
import java.util.Random;

@Service
public class AuthRequestServiceImpl implements AuthRequestService {

    private final AuthRepository authRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final EmailServiceImpl emailServiceImpl;

    public AuthRequestServiceImpl(AuthRepository authRepository, ListingRepository listingRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, EmailServiceImpl emailServiceImpl) {
        this.authRepository = authRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.emailServiceImpl = emailServiceImpl;
    }

    @Override
    public User login(LoginRequestDto loginRequestDto) {
        User user = authRepository.findByEmail(loginRequestDto.email())
                .orElseThrow(()-> new AuthException("User not found"));

        if (!user.isEnabled()){
            throw new RuntimeException("Account is not verified!");
        }

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequestDto.email(),
                        loginRequestDto.password()
                )
        );

        return user;
    }

    @Override
    public User register(RegisterRequest registerRequest) {
        Profile profile = Profile.builder()
                .numOfListings(0L)
                .rating(0.0)
                .build();


        User user = User.builder()
                .email(registerRequest.email())
                .password(passwordEncoder.encode(registerRequest.password()))
                .profile(profile)
                .username(registerRequest.username())
                .role("STUDENT")
                .build();
        user.setVerificationCode(generateVerificationCode());
        user.setVerificationExpiration(Instant.now().plusMillis(300000));
        user.setEnabled(false);

        sendVerificationEmail(user);

        return authRepository.save(user);
    }

    public void verifyUser(VerifyRequestDto verifyRequestDto) {
        Optional<User> optionalUser = authRepository.findByEmail(verifyRequestDto.email());

        if (optionalUser.isPresent()){
            User user = optionalUser.get();

            if (user.getVerificationExpiration().isBefore(Instant.now())) {
                throw new RuntimeException("Verification time expired!");
            }

            if (user.getVerificationCode().equals(verifyRequestDto.code())) {
                user.setEnabled(true);
                user.setVerificationCode(null);
                user.setVerificationExpiration(null);
                authRepository.save(user);
            }else{
                throw new RuntimeException("Incorrect Verification Code!");
            }
        }else{
            throw new RuntimeException("User not found!");
        }
    }

    public void resendVerificationEmail(String email) {
        Optional<User> optionalUser = authRepository.findByEmail(email);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            if (user.isEnabled()){
                throw new RuntimeException("User is already verified");
            }

            user.setVerificationCode(generateVerificationCode());
            user.setVerificationExpiration(Instant.now().plusMillis(300000));
            sendVerificationEmail(user);
            authRepository.save(user);
        }else{
            throw new RuntimeException("User does not exist");
        }
    }

    private void sendVerificationEmail(User user){
        String subject = "Verification Code";
        String verificationCode = "VERIFICATION CODE " + user.getVerificationCode();
        String htmlBody = "<html>"
                + "<body style=\"font-family: Arial, sans-serif;\">"
                + "<div style=\"background-color: #f5f5f5; padding: 20px;\">"
                + "<h2 style=\"color: #333;\">Welcome to our app!</h2>"
                + "<p style=\"font-size: 16px;\">Please enter the verification code below to continue:</p>"
                + "<div style=\"background-color: #fff; padding: 20px; border-radius: 5px; box-shadow: 0 0 10px rgba(0,0,0,0.1);\">"
                + "<h3 style=\"color: #333;\">Verification Code:</h3>"
                + "<p style=\"font-size: 18px; font-weight: bold; color: #007bff;\">" + verificationCode + "</p>"
                + "</div>"
                + "</div>"
                + "</body>"
                + "</html>";

        try{
            emailServiceImpl.sendVerificationEmail(user.getEmail(),subject,htmlBody);
        }catch(MessagingException e){
            e.printStackTrace();
        }

    }

    private String generateVerificationCode(){
        Random random = new Random();

        int code =  random.nextInt(900000) + 100000;

        return String.valueOf(code);
    }

}
