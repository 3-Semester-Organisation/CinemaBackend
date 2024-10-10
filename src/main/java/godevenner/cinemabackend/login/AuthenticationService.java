package godevenner.cinemabackend.login;

public interface AuthenticationService {

    AuthenticationResponse authenticate(LoginRequest loginRequest);
    AuthenticationResponse register(RegisterRequest registerRequest);
}
