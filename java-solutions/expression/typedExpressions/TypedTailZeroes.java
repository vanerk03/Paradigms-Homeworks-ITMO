package expression.typedExpressions;

import expression.Evaluators.CommonEvaluator;

public class TypedTailZeroes<T> extends TypedUnaryExpression<T> {

    public TypedTailZeroes(TypedBothExpressions<T> first, CommonEvaluator<T> evaluator) {
        super(first, evaluator);
    }

    protected T getRes(T x) {
        // return evaluator.tailZeroes(x);
        return null;
    }
}