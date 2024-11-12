package ir.mci.core.repository;

import ir.mci.core.model.UserDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserDto, String> {
    UserDto findByUsername(String username);

}