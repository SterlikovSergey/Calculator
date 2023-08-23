package by.sterlikov.calculator.storage;

import by.sterlikov.calculator.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserStorage {
    void save(User user) throws ClassNotFoundException;
    Optional<User> findByUserName(String userName) throws ClassNotFoundException;
    List<User> findAllUser() throws ClassNotFoundException;
}
