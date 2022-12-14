package expression.Evaluators;

import java.math.BigInteger;

public class BigIntegerEvaluator implements CommonEvaluator<BigInteger> {

    @Override
    public BigInteger add(final BigInteger first, final BigInteger second) {
        return first.add(second);
    }

    @Override
    public BigInteger divide(final BigInteger first, final BigInteger second) {
        return first.divide(second);
    }

    @Override
    public BigInteger max(final BigInteger first, final BigInteger second) {
        return first.max(second);
    }

    @Override
    public BigInteger min(final BigInteger first, final BigInteger second) {
        return first.min(second);
    }

    @Override
    public BigInteger multiply(final BigInteger first, final BigInteger second) {
        return first.multiply(second);
    }

    @Override
    public BigInteger subtract(final BigInteger first, final BigInteger second) {
        return first.subtract(second);
    }
    
    @Override
    public BigInteger negate(BigInteger first) {
        return first.multiply(new BigInteger("-1"));
    }

    @Override
    public BigInteger variable(int x) {
        return BigInteger.valueOf(x);
    }

    @Override
    public BigInteger intToType(int x) {
        return BigInteger.valueOf(x);
    }

    @Override
    public BigInteger count(BigInteger ft) {
        return intToType(ft.bitCount());
    }
}
