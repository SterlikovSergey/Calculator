package by.sterlikov.calculator.service;

import by.sterlikov.calculator.entity.User;
import by.sterlikov.calculator.storage.JdbcUserStorage;

import java.util.Optional;

public class UserService {
    private final JdbcUserStorage jdbcUserStorage = JdbcUserStorage.getInstance();
    private static UserService instance;

    private UserService() {

    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public void create(User user) {
        jdbcUserStorage.save(user);
    }

    public Optional<User> getByUserName(String userName) {
        return jdbcUserStorage.findByUserName(userName);
    }
}
