package ir.mci.core.service;
import ir.mci.core.model.User;
import ir.mci.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService  {
    @Autowired
    protected UserRepository userRepository;
    public UserServiceImpl() {
    }
    @Override
    public Optional<User> list(String username) {
       return userRepository.findById(username);
    }
    @Override
    public void save(User user) {
         userRepository.save(user);
    }
}