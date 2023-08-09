package by.sterlikov.calculator.storage;

import by.sterlikov.calculator.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryUserStorage implements UserStorage {

    private final List<User> users = new ArrayList<>();

    @Override
    public void save(User user) throws ClassNotFoundException {
/*        users.add(user);*/
    }

    @Override
    public Optional<User> findByUserName(String userName) {
/*        for (User user : users) {
            if (user.getName().equals(userName)) {
                return Optional.of(user);
            }
        }*/
            return Optional.empty();
    }
}
