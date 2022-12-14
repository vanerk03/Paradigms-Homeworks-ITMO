package expression.typedExpressions;

import expression.Evaluators.CommonEvaluator;

public class TypedCount<T> extends TypedUnaryExpression<T> {
    public TypedCount(TypedBothExpressions<T> first, CommonEvaluator<T> evaluator) {
        super(first, evaluator);
    }

    @Override
    protected T getRes(T x) {
        return evaluator.count(x);
    }
}