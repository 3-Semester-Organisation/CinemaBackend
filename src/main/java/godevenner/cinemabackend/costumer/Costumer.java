package godevenner.cinemabackend.costumer;

import godevenner.cinemabackend.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Costumer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    private String name;
    private int phoneNumber;
    private String email;
    private LocalDate dateOfBirth;

    public Costumer(String name, int phoneNumber, String email, LocalDate dateOfBirth, User user) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.user = user;
    }
}
