package godevenner.cinemabackend.config;

import godevenner.cinemabackend.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


//this class is not really needed since UserDetailsService already has a method of returning a user by the username.
//but if we wanted to return a user by their email or any other way, we can use this class to implement our own
//costume fetching of the user...
@Configuration
@RequiredArgsConstructor
public class ApplicationConfiguration {

    private final UserRepository userRepository;


    //this bean is used to implement own costume fetching of user from the db.
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> userRepository.findByUsername(username) //change this to findByEmail or phoneNumber or any other ways to find a user.
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
