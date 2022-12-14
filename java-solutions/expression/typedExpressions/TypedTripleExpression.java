package expression.typedExpressions;

public interface TypedTripleExpression<T> {
    T evaluate(int x, int y, int z);
}
