package by.sterlikov.calculator.domain;

public class SubOperation implements Operation {
    private final Double num1;
    private final Double num2;
    private Double result;

    public SubOperation(Double num1, Double num2) {
        this.num1 = num1;
        this.num2 = num2;
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
}
