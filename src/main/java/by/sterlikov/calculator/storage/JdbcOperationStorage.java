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
    public void save(String[] values,String type, Double result,User user){
        System.out.println(user.getId()+Double.parseDouble(values[0])+Double.parseDouble(values[1])+type+result);
        String query = "INSERT INTO Operation(id,first_value,second_value,type,result,) VALUES (?,?,?,?,?)";
        try(Connection connection = MySqlConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,user.getId());
            preparedStatement.setDouble(2,Double.parseDouble(values[0]));
            preparedStatement.setDouble(3,Double.parseDouble(values[1]));
            preparedStatement.setString(4,type);
            preparedStatement.setDouble(5,result);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
