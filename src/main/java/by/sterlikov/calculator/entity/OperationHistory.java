package by.sterlikov.calculator.entity;

import lombok.*;

@Data
@NoArgsConstructor
@Setter
@Getter

public class OperationHistory {

    private String operationValues;
    private String result;

    public OperationHistory(String operationValues, String result) {
        this.operationValues = operationValues;
        this.result = result;
    }
}
