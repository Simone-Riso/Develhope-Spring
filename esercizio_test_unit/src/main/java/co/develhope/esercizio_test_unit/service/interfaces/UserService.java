package co.develhope.esercizio_test_unit.service.interfaces;

import co.develhope.esercizio_test_unit.entity.User;
import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(User user);

    List<User> getAllUsers();

    Optional<User> findUser(long id);

    User updateUser(long id, User user);

    boolean deleteUser(long id);

}
