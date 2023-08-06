package by.sterlikov.calculator.service;

import by.sterlikov.calculator.entity.User;
import by.sterlikov.calculator.storage.InMemoryUserStorage;
import by.sterlikov.calculator.storage.UserStorage;

import java.util.Optional;

public class UserService {

    private final UserStorage userStorage = new InMemoryUserStorage();
    public void create(String name, String userName, String password){
        User user = new User(name,userName,password);
        userStorage.save(user);
    }

    public Optional<User> getByUserName(String userName){
        return userStorage.findByUserName(userName);
    }
}
