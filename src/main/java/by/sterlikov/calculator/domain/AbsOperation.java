package by.sterlikov.calculator.domain;

import by.sterlikov.calculator.entity.User;

public class AbsOperation implements Operation{
    private final Double num;
    private final String type;
    private Double result;
    private final User author;

    public AbsOperation(Double num,String type,User author) {
        this.num = num;
        this.author = author;
        this.type = type;
    }

    @Override
    public Operation execute() {
        this.result = Math.abs(num);
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
