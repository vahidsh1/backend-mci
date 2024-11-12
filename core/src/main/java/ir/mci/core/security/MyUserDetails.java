package ir.mci.core.security;

import ir.mci.core.model.UserDto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

public class MyUserDetails implements UserDetails {

    private final UserDto userDto;

    public MyUserDetails(UserDto userDto) {
        this.userDto = userDto;
    }

    @Override

    public String getUsername() {
        return userDto.getUsername();
    }

    @Override
    public String getPassword() {
        return userDto.getPassword();

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Adjust the format to match your ex_date format
        Date expirationDate;
        try {
            expirationDate = dateFormat.parse(userDto.getEx_date());
        } catch (ParseException e) {
            // Handle parsing errors, e.g., log the error and return false
            e.printStackTrace();
            return false;
        }

        // Compare the expiration date with the current date
        Date currentDate = new Date();
        return !expirationDate.before(currentDate);
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return "1".equals(userDto.getEnabled());
    }

}