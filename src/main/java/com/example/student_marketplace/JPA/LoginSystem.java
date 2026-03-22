package com.example.student_marketplace.JPA;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "loginSystem")
public class LoginSystem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull private String username;
    @NonNull String email;
    @NonNull private String role;
    @NonNull private String password_hash;
    @NonNull private Instant joined_at;
    private Instant updated_at;

    @OneToOne(mappedBy = "profileID", cascade = CascadeType.ALL)
    private Profiles profileID;

    @OneToMany(mappedBy = "senderID")
    private List<Messages> senderMessages;

    @OneToMany(mappedBy = "recipientID")
    private List<Messages> recipientMessages;
}
