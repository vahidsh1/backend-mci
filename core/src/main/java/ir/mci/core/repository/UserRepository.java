package ir.mci.core.repository;

import ir.mci.core.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;

@Repository
public interface UserRepository extends BaseRepository<User, String> {
}