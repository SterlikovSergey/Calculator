package by.sterlikov.calculator.domain;

public class CosOperation implements Operation {
    private final Double num;
    private Double result;

    public CosOperation(Double num) {
        this.num = num;
    }

    @Override
    public Operation execute() {
        this.result = Math.cos(num);
        return this;
    }

    @Override
    public Double result() {
        return result;
    }
}
