package by.sterlikov.calculator.factory;

import by.sterlikov.calculator.domain.*;

public class OperationFactory {
    private static OperationFactory instance;
    private OperationFactory(){}
    public static OperationFactory getInstance(){
        if(instance == null){
            instance = new OperationFactory();
        }
        return instance;
    }

    public Operation getOperation(String[] values, Operation.Type type) {
        return switch (type) {
            case SUM -> new SumOperation(Double.parseDouble(values[0]), Double.parseDouble(values[1]));
            case SUB -> new SubOperation(Double.parseDouble(values[0]), Double.parseDouble(values[1]));
            case COS -> new CosOperation(Double.parseDouble(values[0]));
            case SIN -> new SinOperation(Double.parseDouble(values[0]));
        };
    }
}