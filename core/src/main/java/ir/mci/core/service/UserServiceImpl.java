package ir.mci.core.service;
import ir.mci.core.model.User;
import ir.mci.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService  {
    @Autowired
    protected UserRepository userRepository;
    public UserServiceImpl() {
    }
    @Override
    public void list(User user) {
            userRepository.getById(user);
    }
}