package expression.typedExpressions;

import expression.Evaluators.CommonEvaluator;

public abstract class TypedBinaryOperation<T> implements TypedBothExpressions<T> {

    private final TypedBothExpressions<T> first;
    private final TypedBothExpressions<T> second;
    protected final CommonEvaluator<T> evaluator;

    protected abstract T getRes(T first, T second);

    public TypedBinaryOperation(final TypedBothExpressions<T> first, final TypedBothExpressions<T> second, final CommonEvaluator<T> evaluator) {
        this.first = first;
        this.second = second;
        this.evaluator = evaluator;
    }

    public T evaluate(final int x, final int y, final int z) {
        return getRes(first.evaluate(x, y, z), second.evaluate(x, y, z));
    }

    public T evaluate(final int x) {
        return getRes(first.evaluate(x), second.evaluate(x));
    }
}
