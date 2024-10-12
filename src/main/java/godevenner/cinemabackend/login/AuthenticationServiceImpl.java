package godevenner.cinemabackend.login;

import godevenner.cinemabackend.config.JwtService;
import godevenner.cinemabackend.customer.Customer;
import godevenner.cinemabackend.customer.CustomerRepository;
import godevenner.cinemabackend.user.Role;
import godevenner.cinemabackend.user.User;
import godevenner.cinemabackend.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final CustomerRepository costumerRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    @Override
    public AuthenticationResponse register(RegisterRequest registerRequest) {

        try {
            User registerUser = User.builder()
                    .username(registerRequest.username())
                    .password(passwordEncoder.encode(registerRequest.password()))
                    .role(Role.ROLE_USER)
                    .build();
            User registedUser = userRepository.save(registerUser);

            Customer newCostumer = new Customer(
                    registedUser,
                    registerRequest.fullName(),
                    registerRequest.phoneNumber(),
                    registerRequest.email(),
                    LocalDate.parse(registerRequest.birthDate())
            );
            costumerRepository.save(newCostumer);

            return generatedAuthenticationResponse(registedUser);

        } catch (DateTimeParseException e) {
            // Handle parsing errors (invalid date format)
            throw new IllegalArgumentException("Invalid date format for birthDate: " + registerRequest.birthDate(), e);
        }
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
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("role", user.getRole());
        String token = jwtService.generateToken(extraClaims, user);
        return new AuthenticationResponse(token);
    }
}
