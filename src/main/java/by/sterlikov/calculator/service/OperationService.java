package by.sterlikov.calculator.service;

import by.sterlikov.calculator.entity.Operation;

import java.util.Optional;

public class OperationService {
    private static OperationService instance;
    private OperationService(){}
    public static OperationService getInstance(){
        if(instance == null){
            instance = getInstance();
        }
        return new OperationService();
    }
    public Optional<Operation> calculate(double num1, double num2, String type) {
        switch (type) {
            case "sum" -> {
                double sum = num1 + num2;
                return Optional.of(new Operation(num1, num2, type, sum));
            }
            case "sub" -> {
                double sub = num1 - num2;
                return Optional.of(new Operation(num1, num2, type, sub));
            }
            case "mul" -> {
                double mul = num1 * num2;
                return Optional.of(new Operation(num1, num2, type, mul));
            }
            case "div" -> {
                double div = num1 / num2;
                return Optional.of(new Operation(num1, num2, type, div));
            }
            default -> {
                return Optional.empty();
            }
        }
    }
}
