package by.sterlikov.calculator.storage;

import by.sterlikov.calculator.entity.User;

import java.io.IOException;
import java.sql.*;
import java.util.Optional;

public class JdbcUserStorage implements UserStorage{
    @Override
    public void save(User user) {
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
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_calculator",
                "root","root")){
            String query = "SELECT * FROM USER WHERE user_name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,userName);
            User user = new User();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                String userNameX = resultSet.getString("user_name");
                String passsword = resultSet.getString("password");
                user.setName(name);
                user.setUserName(userNameX);
                user.setPassword(passsword);
            }
            return Optional.of(user);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
