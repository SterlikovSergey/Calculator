package by.sterlikov.calculator.domain;

import by.sterlikov.calculator.entity.User;

public class SqrtOperation implements Operation {
    private final Double num;
    private final String type;
    private Double result;

    private final User author;

    public SqrtOperation(Double num, String type, User author) {
        this.num = num;
        this.type = type;
        this.author = author;
    }

    @Override
    public Operation execute() {
        this.result = Math.sqrt(num);
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
        return type + "(" + num + ") = ";
    }

}
