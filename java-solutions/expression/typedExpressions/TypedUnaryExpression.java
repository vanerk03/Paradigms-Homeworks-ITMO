package expression.typedExpressions;

import expression.Evaluators.CommonEvaluator;

public abstract class TypedUnaryExpression<T> implements TypedBothExpressions<T> {
    private final TypedBothExpressions<T> first;
    protected final CommonEvaluator<T> evaluator;

    protected abstract T getRes(T x);

    public TypedUnaryExpression(final TypedBothExpressions<T> first, final CommonEvaluator<T> evaluator) {
        this.first = first;
        this.evaluator = evaluator;
    }

    @Override
    public T evaluate(final int x) {
        return getRes(first.evaluate(x));
    }

    @Override
    public T evaluate(final int x, final int y, final int z) {
        return getRes(first.evaluate(x, y, z));
    }
    
}
