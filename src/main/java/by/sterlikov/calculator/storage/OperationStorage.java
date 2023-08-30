package by.sterlikov.calculator.storage;

import by.sterlikov.calculator.domain.Operation;
import by.sterlikov.calculator.entity.OperationHistory;
import by.sterlikov.calculator.entity.User;

import java.util.List;

public interface OperationStorage {

    void save(Operation operation) throws ClassNotFoundException;
    List<OperationHistory> findAllOperations();
    List<OperationHistory> findAllOperationsByUserName(User user);

}
