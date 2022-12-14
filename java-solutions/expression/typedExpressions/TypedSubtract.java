package expression.typedExpressions;

import expression.Evaluators.CommonEvaluator;

public class TypedSubtract<T> extends TypedBinaryOperation<T> {
    
    public TypedSubtract(TypedBothExpressions<T> first, TypedBothExpressions<T> second, CommonEvaluator<T> evaluator) {
        super(first, second, evaluator);
    }

    public T getRes(T first, T second) {
        return evaluator.subtract(first, second);
    }
}
