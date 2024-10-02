package godevenner.cinemabackend.user;

import godevenner.cinemabackend.costumer.Costumer;
import godevenner.cinemabackend.employee.Employee;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Costumer costumer;

//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
//    private Employee employee;

    private String username;
    private String password;

    public User(String username, String password) {
//        this.costumer = costumer;
//        this.employee = employee;
        this.username = username;
        this.password = password;
    }
}
