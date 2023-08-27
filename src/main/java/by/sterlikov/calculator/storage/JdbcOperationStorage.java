package by.sterlikov.calculator.storage;

import by.sterlikov.calculator.domain.Operation;
import by.sterlikov.calculator.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcOperationStorage implements OperationStorage{
    private static final String INSERT_QUERY  = "INSERT INTO Operations(id_user, operation, result) VALUES (?,?,?)";
    private static JdbcOperationStorage instance;

    private JdbcOperationStorage() {}
    public static JdbcOperationStorage getInstance(){
        if(instance == null){
            instance = new JdbcOperationStorage();
        }
        return instance;
    }

    @Override
    public void save(Operation operation) {
        try (Connection connection = MySqlConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);
            preparedStatement.setInt(1, operation.author().getId());
            preparedStatement.setString(2,operation.toString());
            preparedStatement.setString(3, String.valueOf(operation.result()));
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
