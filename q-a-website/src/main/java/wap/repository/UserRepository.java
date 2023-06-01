package wap.repository;

import org.springframework.data.repository.CrudRepository;
import wap.model.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findByUsername(String username);
}
