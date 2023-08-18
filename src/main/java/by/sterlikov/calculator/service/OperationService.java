package by.sterlikov.calculator.service;

import by.sterlikov.calculator.domain.Operation;
import by.sterlikov.calculator.entity.User;
import by.sterlikov.calculator.storage.JdbcOperationStorage;

public class OperationService {
    private final JdbcOperationStorage jdbcOperationStorage = JdbcOperationStorage.getInstance();
    private static OperationService instance;
    private OperationService(){}
    public static OperationService getInstance(){
        if(instance == null){
            instance = new OperationService();
        }
        return instance;
    }
    public Operation calculate(Operation operation) {
        System.out.println(operation.toString());
        return operation.execute();

    }
}

