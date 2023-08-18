package by.sterlikov.calculator.domain;

public interface Operation {

    Operation execute();

    Double result();

    enum Type {
        SUM, SUB, COS, SIN
    }
}
