package by.sterlikov.calculator.storage;

import by.sterlikov.calculator.domain.Operation;
import by.sterlikov.calculator.entity.User;

public interface OperationStorage {

    void save(String[] values, String type, Double result, User user) throws ClassNotFoundException;
}
