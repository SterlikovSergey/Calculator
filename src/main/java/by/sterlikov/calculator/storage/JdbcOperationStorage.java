package by.sterlikov.calculator.storage;

import by.sterlikov.calculator.domain.Operation;
import by.sterlikov.calculator.entity.OperationHistory;
import by.sterlikov.calculator.entity.User;
import by.sterlikov.calculator.factory.OperationFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcOperationStorage implements OperationStorage{
    private static final String INSERT_QUERY  = "INSERT INTO Operations(id_user, operation, result) VALUES (?,?,?)";
    private static final String SELECT_ALL_OPERATIONS_QUERY = "SELECT * FROM Operations";
    private static final String SELECT_ALL_BY_USER_NAME = "SELECT operation, result\n" +
            "FROM Operations AS o\n" +
            "INNER JOIN User AS u ON u.id = o.id_user\n" +
            "WHERE name = ?";
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
            preparedStatement.setString(2,operation.getOperationValues());
            preparedStatement.setString(3, String.valueOf(operation.result()));
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<OperationHistory> findAllOperations() {
        List<OperationHistory> operations = new ArrayList<>();
        try (Connection connection = MySqlConnection.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_OPERATIONS_QUERY);
            while (resultSet.next()){
                String history = resultSet.getString(3);
                String result = resultSet.getString(4);
                operations.add(new OperationHistory(history,result));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return operations;
    }

    @Override
    public List<OperationHistory> findAllOperationsByUserName(User user) {
        List<OperationHistory> operations = new ArrayList<>();
        try(Connection connection = MySqlConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BY_USER_NAME);
            preparedStatement.setString(1, user.getUserName());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String operation = resultSet.getString(1);
                String result = resultSet.getString(2);
                operations.add(new OperationHistory(operation,result));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return operations;
    }
}
