package godevenner.cinemabackend.login;

import godevenner.cinemabackend.user.User;
import godevenner.cinemabackend.user.UserService;
import godevenner.cinemabackend.user.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest registerRequest) {

        Optional<User> isUsernameTaken = userService.findByUsername(registerRequest.username());
        if (isUsernameTaken.isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        AuthenticationResponse authResponse = authenticationService.register(registerRequest);
        return ResponseEntity.ok(authResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest loginRequest) {

       AuthenticationResponse authResponse = authenticationService.authenticate(loginRequest);

       //TODO implement feature to tell user wrong credentials if inputed wrong username or password.

       return ResponseEntity.ok(authResponse);
    }
}
