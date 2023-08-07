package by.sterlikov.calculator.storage;

import by.sterlikov.calculator.entity.User;

import java.sql.SQLException;
import java.util.Optional;

public interface UserStorage {
    public void save(User user);
    Optional<User> findByUserName(String userName);
}
