package by.sterlikov.calculator.domain;

import by.sterlikov.calculator.entity.User;

public class SubOperation implements Operation {
    private final Double num1;
    private final String type;
    private final Double num2;
    private Double result;
    private final User author;

    public SubOperation(Double num1, Double num2, String type, User author) {
        this.num1 = num1;
        this.num2 = num2;
        this.type = type;
        this.author = author;
    }

    @Override
    public Operation execute() {
        this.result = num1 - num2;
        return this;
    }

    @Override
    public Double result() {
        return result;
    }

    @Override
    public User author() {
        return author;
    }

    @Override
    public String getOperationValues() {
        return num1 + " " + type + " " + num2 + " = ";
    }
}
