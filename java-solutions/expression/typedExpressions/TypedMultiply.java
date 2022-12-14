package expression.typedExpressions;

import expression.Evaluators.CommonEvaluator;

public class TypedMultiply<T> extends TypedBinaryOperation<T> {

    public TypedMultiply(TypedBothExpressions<T> first, TypedBothExpressions<T> second, CommonEvaluator<T> evaluator) {
        super(first, second, evaluator);
    }

    @Override
    protected T getRes(T first, T second) {
        return evaluator.multiply(first, second);
    }
}
