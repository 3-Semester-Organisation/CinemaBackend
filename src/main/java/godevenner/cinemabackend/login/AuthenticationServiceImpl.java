package godevenner.cinemabackend.login;

import godevenner.cinemabackend.config.JwtService;
import godevenner.cinemabackend.user.Role;
import godevenner.cinemabackend.user.User;
import godevenner.cinemabackend.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    @Override
    public AuthenticationResponse register(RegisterRequest registerRequest) {
       User registerUser = User.builder()
               .username(registerRequest.username())
               .password(passwordEncoder.encode(registerRequest.password()))
               .role(Role.USER)
               .build();
       userRepository.save(registerUser);

       return generatedAuthenticationResponse(registerUser);
    }

    @Override
    public AuthenticationResponse authenticate(LoginRequest loginRequest) {
        //is username or password is wrong authenticationManager will throw an exception
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.username(),
                        loginRequest.password())
        );

        User user = userRepository.findByUsername(loginRequest.username())
                .orElseThrow();

        return generatedAuthenticationResponse(user);
    }

    private AuthenticationResponse generatedAuthenticationResponse(User user) {
        String token = jwtService.generateToken(user);
        return new AuthenticationResponse(token);
    }
}
