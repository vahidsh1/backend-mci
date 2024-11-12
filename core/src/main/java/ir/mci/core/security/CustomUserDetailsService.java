package ir.mci.core.security;

import ir.mci.core.model.UserDto;
import ir.mci.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    private boolean isAccountExpired(String expirationDateString) {
        if (expirationDateString == null || expirationDateString.isEmpty()) {
            return false; // If no expiration date is set, the account is not expired
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Adjust the format to match your string format
        Date expirationDate;
        try {
            expirationDate = dateFormat.parse(expirationDateString);
        } catch (ParseException e) {
            // Handle parsing errors, e.g., log the error and return a default value
            e.printStackTrace();
            return false; // Or handle it differently based on your requirements
        }

        LocalDate currentDate = LocalDate.now();
        LocalDate expirationLocalDate = expirationDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        return expirationLocalDate.isBefore(currentDate);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        // Determine enabled status based on your criteria, e.g., using the "status" field
        boolean enabled = "1".equals(user.getEnabled());

        return new User(user.getUsername(), user.getPassword(), enabled,
                true, true, true, getAuthorities(user));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(UserDto user) {
        return user.getAuthorities().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getAuthority()))
                .collect(Collectors.toList());
    }
}

