package godevenner.cinemabackend.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import godevenner.cinemabackend.customer.Customer;
import godevenner.cinemabackend.employee.Employee;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Table(name = "_user") if using postgres db, one would need to name the user table something else, since there is automatically already a user table.
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonBackReference
    private Customer customer;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonBackReference
    private Employee employee;

    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
