package ir.mci.core.service;

import ir.mci.core.model.User;

import java.util.Optional;

public interface UserService {

    public Optional<User> list(String username);
    public void save(User user);

}
