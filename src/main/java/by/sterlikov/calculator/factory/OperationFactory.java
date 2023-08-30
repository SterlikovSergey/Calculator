package by.sterlikov.calculator.factory;

import by.sterlikov.calculator.domain.*;
import by.sterlikov.calculator.entity.User;

public class OperationFactory {
    private static OperationFactory instance;

    private OperationFactory() {
    }

    public static OperationFactory getInstance() {
        if (instance == null) {
            instance = new OperationFactory();
        }
        return instance;
    }

    public Operation getOperation(String[] values, Operation.Type type, User author) {
        return switch (type) {

            case SUM -> new SumOperation(Double.parseDouble(values[0]), Double.parseDouble(values[1]),
                    String.valueOf(type), author);

            case SUB -> new SubOperation(Double.parseDouble(values[0]), Double.parseDouble(values[1]),
                    String.valueOf(type), author);

            case EXP -> new ExpOperation(Double.parseDouble(values[0]), Double.parseDouble(values[1]),
                    String.valueOf(type), author);

            case COS -> new CosOperation(Double.parseDouble(values[0]), String.valueOf(type), author);

            case SIN -> new SinOperation(Double.parseDouble(values[0]), String.valueOf(type), author);

            case ABS -> new AbsOperation(Double.parseDouble(values[0]), String.valueOf(type), author);

            case FLOOR -> new FloorOperation(Double.parseDouble(values[0]), String.valueOf(type), author);

            case SQRT -> new SqrtOperation(Double.parseDouble(values[0]), String.valueOf(type), author);
        };
    }
}