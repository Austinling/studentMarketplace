package com.austin.student_marketplace.auth;

/*
import com.austin.student_marketplace.Entities.Messagesz

 */
import com.austin.student_marketplace.audit.TimestampDetails;
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
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends TimestampDetails {
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
    private String password;

    @OneToOne
    @JoinColumn(name = "profileId",nullable = false)
    private Profile profile;
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
        return Objects.hash(id, username, email, role, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", password_hash='" + password + '\'' +
                '}';
    }
}
