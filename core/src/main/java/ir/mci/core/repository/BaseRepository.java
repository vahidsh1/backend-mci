package ir.mci.core.repository;

import ir.mci.core.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.Id;

@NoRepositoryBean
public interface BaseRepository<T,Id> extends JpaRepository<T,Id> {

}