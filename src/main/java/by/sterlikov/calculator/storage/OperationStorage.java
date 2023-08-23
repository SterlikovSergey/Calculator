package by.sterlikov.calculator.storage;

import by.sterlikov.calculator.domain.Operation;
import by.sterlikov.calculator.entity.User;

public interface OperationStorage {

    void save(User user,String[] values, String type, Double result) throws ClassNotFoundException;
}
