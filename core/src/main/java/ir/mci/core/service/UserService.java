package ir.mci.core.service;

import ir.mci.core.model.UserDto;

import java.util.Optional;

public interface UserService {

    public Optional<UserDto> list(String username);
    public void save(UserDto userDto);

}
