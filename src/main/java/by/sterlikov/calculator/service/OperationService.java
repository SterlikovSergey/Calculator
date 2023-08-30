package by.sterlikov.calculator.service;

import by.sterlikov.calculator.domain.Operation;
import by.sterlikov.calculator.entity.OperationHistory;
import by.sterlikov.calculator.entity.User;
import by.sterlikov.calculator.storage.JdbcOperationStorage;

import java.util.List;

public class OperationService {
    private final JdbcOperationStorage jdbcOperationStorage = JdbcOperationStorage.getInstance();
    private static OperationService instance;

    private OperationService() {
    }

    public static OperationService getInstance() {
        if (instance == null) {
            instance = new OperationService();
        }
        return instance;
    }

    public Operation calculate(Operation operation) {
        Operation execute = operation.execute();
        jdbcOperationStorage.save(execute);
        return operation.execute();

    }

    public List<OperationHistory> getAllOperations() {
        return jdbcOperationStorage.findAllOperations();
    }

    public List<OperationHistory> getAllOperationByUserName(User user) {
        return jdbcOperationStorage.findAllOperationsByUserName(user);
    }
}

