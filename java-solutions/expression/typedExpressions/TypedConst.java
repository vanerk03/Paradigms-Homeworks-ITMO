package expression.typedExpressions;

public class TypedConst<T> implements TypedBothExpressions<T> {
    private final T CONST;

    public TypedConst(final T CONST) {
        this.CONST = CONST;
    }

    public T evaluate(final int x) {
        return CONST;
    }

    public T evaluate(final int x, final int y, final int z) {
        return CONST;
    }
}
