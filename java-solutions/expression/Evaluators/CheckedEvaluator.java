package expression.Evaluators;

public class CheckedEvaluator implements CommonEvaluator<Integer> {

    @Override
    public Integer add(final Integer ft, final Integer sc) {
        if ((ft > 0 && sc > 0 && ft + sc <= 0) || (ft < 0 && sc < 0 && ft + sc >= 0)) {
            throw new OverflowException("overflow");
        }
        return ft + sc;
    }

    @Override
    public Integer divide(final Integer ft, final Integer sc) {
        if (sc == 0 || (ft == Integer.MIN_VALUE && sc == -1)) {
            throw new OverflowException("zero division");
        }
        return ft / sc;
    }

    @Override
    public Integer max(final Integer ft, final Integer sc) {
        return Math.max(ft, sc);
    }

    @Override
    public Integer min(final Integer ft, final Integer sc) {
        return Math.min(ft, sc);
    }

    @Override
    public Integer multiply(final Integer ft, final Integer sc) {
        final int res = ft * sc;
        if ((ft != 0 && res / ft != sc) || (sc != 0 && res / sc != ft)) {
            throw new OverflowException("overflow");
        }
        return ft * sc;
    }

    @Override
    public Integer negate(final Integer ft) {
        if (ft == Integer.MIN_VALUE) {
            throw new OverflowException("overflow");
        }
        return -1 * ft;
    }

    @Override
    public Integer subtract(final Integer ft, final Integer sc) {
        if ((ft < 0 && sc > 0 && ft - sc > 0) ||
                (ft > 0 && sc < 0 && ft - sc < 0) ||
                (ft < 0 && sc > 0 && ft - sc >= 0) ||
                (ft >= 0 && sc < 0 && ft - sc <= 0)) {
            throw new OverflowException("overflow");
        }
        return ft - sc;
    }

    @Override
    public Integer variable(final int ft) {
        return ft;
    }
    
    @Override
    public Integer intToType(final int x) {
        return Integer.valueOf(x);
    }

    @Override
    public Integer count(final Integer ft) {
        return Integer.bitCount(ft);
    }
}
