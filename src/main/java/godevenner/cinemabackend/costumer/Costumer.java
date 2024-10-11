package godevenner.cinemabackend.costumer;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import godevenner.cinemabackend.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Costumer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @JsonManagedReference
    private User user;

    private String name;
    private String phoneNumber;
    private String email;
    private LocalDate dateOfBirth;


    public boolean isOldEnough(int requiredAge) {
        LocalDate currentDate = LocalDate.now();
        int age = Period.between(dateOfBirth, currentDate).getYears();
        return age >= requiredAge;
    }

    public Costumer(User user, String name, String phoneNumber, String email, LocalDate dateOfBirth) {
        this.user = user;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public Costumer(String email) {
        this.email = email;
    }
}
