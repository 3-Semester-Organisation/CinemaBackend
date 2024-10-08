package godevenner.cinemabackend.login;

public interface AuthenticationService {

    AuthenticationResponse authenticate(String username, String password);
    AuthenticationResponse register(String username, String password);
}
