package expression.typedExpressions;

import expression.Evaluators.CommonEvaluator;

public class TypedLeadingZeroes<T> extends TypedUnaryExpression<T> {

    public TypedLeadingZeroes(TypedBothExpressions<T> first, CommonEvaluator<T> evaluator) {
        super(first, evaluator);
    }

    protected T getRes(T x) {
        // return evaluator.leadingZeroes(x);
        return null;
    }
}
