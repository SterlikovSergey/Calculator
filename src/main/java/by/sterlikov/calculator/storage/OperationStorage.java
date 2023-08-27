package by.sterlikov.calculator.storage;

import by.sterlikov.calculator.domain.Operation;
import by.sterlikov.calculator.entity.User;

public interface OperationStorage {

    void save(Operation operation) throws ClassNotFoundException;
}
