package godevenner.cinemabackend.login;

import java.time.LocalDate;

public record RegisterRequest(
        String username,
        String password,
        String fullName,
        String phoneNumber,
        String email,
        LocalDate birthDate
        //add other information such as first- and last name, birthday and phone number, email
) {
}
