package com.austin.student_marketplace.auth;

/*
import com.austin.student_marketplace.Entities.Messagesz

 */
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column( name = "username", nullable = false)
    private String username;

    @Column( name = "email", nullable = false)
    private String email;

    @Column (name = "role", nullable = false)
    private String role;

    @Column(name = "password", nullable = false)
    @NonNull private String password;

    @Column(name = "joinedAt", updatable = false, nullable = false)
    private Instant joinedAt;

    @Column(name = "updatedAt", nullable = false)
    private Instant updatedAt;



    @OneToOne(mappedBy = "profile", cascade = CascadeType.ALL, orphanRemoval = true)
    private Profiles profile;

    /*

    @OneToMany(mappedBy = "sender")
    private List<Messages> senderMessages;

    @OneToMany(mappedBy = "recipient")
    private List<Messages> recipientMessages;

     */

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, email, role, password, joinedAt, updatedAt);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", password_hash='" + password + '\'' +
                ", joinedAt=" + joinedAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
