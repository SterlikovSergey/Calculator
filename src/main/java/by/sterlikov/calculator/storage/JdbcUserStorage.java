package by.sterlikov.calculator.storage;

import by.sterlikov.calculator.entity.User;

import java.util.Optional;

public class JdbcUserStorage implements UserStorage{
    @Override
    public void save(User user) {

    }

    @Override
    public Optional<User> findByUserName(String userName) {
        return Optional.empty();
    }
}
