package expression.typedExpressions;

import expression.Evaluators.CommonEvaluator;

public class TypedMax<T> extends TypedBinaryOperation<T> {
    
    public TypedMax(TypedBothExpressions<T> first, TypedBothExpressions<T> second, CommonEvaluator<T> evaluator) {
        super(first, second, evaluator);
    }

    public T getRes(T first, T second) {
        return evaluator.max(first, second);
    }
}
