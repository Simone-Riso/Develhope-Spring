package co.develhope.esercizio_test_unit.service.implementation;

import co.develhope.esercizio_test_unit.entity.User;
import co.develhope.esercizio_test_unit.repository.UserRepository;
import co.develhope.esercizio_test_unit.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User createUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findUser(long id) {
        return Optional.empty();
    }

    @Override
    public User updateUser(long id, User user) {
        user.setId(id);
        return userRepository.saveAndFlush(user);
    }

    @Override
    public boolean deleteUser(long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
