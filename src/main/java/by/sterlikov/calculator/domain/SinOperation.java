package by.sterlikov.calculator.domain;

public class SinOperation implements Operation {
    private final Double num;
    private Double result;

    public SinOperation(Double num) {
        this.num = num;
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
}
