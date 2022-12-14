package expression.Evaluators;

public class DoubleEvaluator implements CommonEvaluator<Double> {

    @Override
    public Double add(final Double first, final Double second) {
        return first + second;
    }

    @Override
    public Double divide(final Double first, final Double second) {
        return first / second;
    }

    @Override
    public Double max(final Double first, final Double second) {
        return Math.max(first, second);
    }

    @Override
    public Double min(final Double first, final Double second) {
        return Math.min(first, second);
    }

    @Override
    public Double multiply(final Double first, final Double second) {
        return first * second;
    }

    @Override
    public Double subtract(final Double first, final Double second) {
        return first - second;
    }

    @Override
    public Double variable(int x) {
        return Double.valueOf(x);
    }

    @Override
    public Double negate(Double first) {
        return -first;
    }

    // Testing this approach (might not work though)
    @Override
    public Double intToType(int x) {
        return Double.valueOf(x);
    }

    @Override
    public Double count(Double ft) {
        return (double) Long.bitCount(Double.doubleToLongBits(ft));
    }
}
