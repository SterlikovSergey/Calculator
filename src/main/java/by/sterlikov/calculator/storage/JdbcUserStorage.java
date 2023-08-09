package by.sterlikov.calculator.storage;

import by.sterlikov.calculator.entity.User;

import java.sql.*;
import java.util.Optional;

public class JdbcUserStorage implements UserStorage{

    private static JdbcUserStorage instance;
    private JdbcUserStorage(){}

    public static JdbcUserStorage getInstance(){
        if(instance == null){
            instance = getInstance();
        }
        return instance;
    }
    @Override
    public void save(User user){
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_calculator",
                "root", "root")){
            String query = "INSERT INTO User(name,user_name,password) VALUE (?,?,?)";
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
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_calculator",
                "root","root")){
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,userName);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = new User();
            while (resultSet.next()){
                String name;
                String userNameX;
                String password;
                name = resultSet.getString("name");
                userNameX = resultSet.getString("user_name");
                password = resultSet.getString("password");
                user.setName(name);
                user.setUserName(userNameX);
                user.setPassword(password);
            }
            return Optional.of(user);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
