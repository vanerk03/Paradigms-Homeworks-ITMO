package expression.typedExpressions;

import expression.Evaluators.CommonEvaluator;

public class TypedMinus<T> extends TypedUnaryExpression<T> {

    public TypedMinus(TypedBothExpressions<T> first, CommonEvaluator<T> evaluator) {
        super(first, evaluator);
    }

    @Override
    protected T getRes(T x) {
        return evaluator.negate(x);
    }

}
