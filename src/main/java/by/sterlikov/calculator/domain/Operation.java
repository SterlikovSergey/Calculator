package by.sterlikov.calculator.domain;

import by.sterlikov.calculator.entity.User;

public interface Operation {

    Operation execute();

    Double result();

    User author();


    enum Type {
        SUM, SUB, COS, SIN
    }
}
