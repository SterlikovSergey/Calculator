package by.sterlikov.calculator.service;

import by.sterlikov.calculator.entity.User;
import by.sterlikov.calculator.storage.JdbcUserStorage;

import java.util.Optional;

public class UserService {

    private final JdbcUserStorage jdbcUserStorage = new JdbcUserStorage();
   /* private final UserStorage userStorage = new InMemoryUserStorage();*/
    public void create(String name, String userName, String password){
        User user = new User(name,userName,password);
        /*userStorage.save(user);*/
            jdbcUserStorage.save(user);
    }

    public Optional<User> getByUserName(String userName) {
        /*return userStorage.findByUserName(userName);*/
        return jdbcUserStorage.findByUserName(userName);
    }
}
