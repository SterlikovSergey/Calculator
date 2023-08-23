package by.sterlikov.calculator.storage;

import by.sterlikov.calculator.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcOperationStorage implements OperationStorage{
    private static JdbcOperationStorage instance;

    private JdbcOperationStorage() {}
    public static JdbcOperationStorage getInstance(){
        if(instance == null){
            instance = new JdbcOperationStorage();
        }
        return instance;
    }

    @Override
    public void save(User user, String[] values, String type, Double result) {
        System.out.println("sout save jdbc: " + user.getId() + Double.parseDouble(values[0])
                + Double.parseDouble(values[1]) + type + result);
        String query = "INSERT INTO Operation(id_user,first_value,second_value,type,result) VALUES (?,?,?,?,?)";
        try (Connection connection = MySqlConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, String.valueOf(values[0]));
            preparedStatement.setString(3, String.valueOf(values[1]));
            preparedStatement.setString(4, type);
            preparedStatement.setString(5, String.valueOf(result));
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
