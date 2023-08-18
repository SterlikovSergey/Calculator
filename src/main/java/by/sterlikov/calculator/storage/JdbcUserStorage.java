package by.sterlikov.calculator.storage;

import by.sterlikov.calculator.entity.User;

import java.sql.*;
import java.util.Optional;

public class JdbcUserStorage implements UserStorage{

    private static JdbcUserStorage instance;
    private JdbcUserStorage(){}

    public static JdbcUserStorage getInstance(){
        if(instance == null){
            instance = new JdbcUserStorage();
        }
        return instance;
    }
    @Override
    public void save(User user){
        String query = "INSERT INTO User(name,user_name,password) VALUES (?,?,?)";
        try (Connection connection = MySqlConnection.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getUserName());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<User> findByUserName(String userName) {
        String query = "SELECT * FROM User WHERE user_name = ?";
        try(Connection connection = MySqlConnection.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,userName);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = new User();
            while (resultSet.next()){
                int id;
                String name;
                String userNameX;
                String password;
                id = resultSet.getInt("id");
                name = resultSet.getString("name");
                userNameX = resultSet.getString("user_name");
                password = resultSet.getString("password");
                user.setId(id);
                user.setName(name);
                user.setUserName(userNameX);
                user.setPassword(password);
            }
            if (user.getUserName() != null) {
                return Optional.of(user);
            } else {
                return Optional.empty();
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
