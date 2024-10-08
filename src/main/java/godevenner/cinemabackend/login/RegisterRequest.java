package godevenner.cinemabackend.login;

public record RegisterRequest(
        String username,
        String password
        //add other information such as first- and last name, birthday and phone number, email
) {
}
