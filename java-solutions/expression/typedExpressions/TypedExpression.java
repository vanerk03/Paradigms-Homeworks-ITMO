package expression.typedExpressions;

public interface TypedExpression<T> {
    T evaluate(int x);
}
