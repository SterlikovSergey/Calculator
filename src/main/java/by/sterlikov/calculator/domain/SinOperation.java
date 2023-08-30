package by.sterlikov.calculator.domain;

import by.sterlikov.calculator.entity.User;
import lombok.Getter;

public class SinOperation implements Operation {
    private final Double num;
    private final String type;
    private Double result;
    private final User author;

    public SinOperation(Double num, String type, User author) {
        this.num = num;
        this.author = author;
        this.type = type;
    }

    @Override
    public Operation execute() {
        this.result = Math.sin(num);
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
