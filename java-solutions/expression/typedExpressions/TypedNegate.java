package expression.typedExpressions;

import expression.Evaluators.CommonEvaluator;

public class TypedNegate<T> extends TypedUnaryExpression<T> {

    public TypedNegate(TypedBothExpressions<T> first, CommonEvaluator<T> evaluator) {
        super(first, evaluator);
    }

    @Override
    protected T getRes(T x) {
        return evaluator.negate(x);
    }
}
