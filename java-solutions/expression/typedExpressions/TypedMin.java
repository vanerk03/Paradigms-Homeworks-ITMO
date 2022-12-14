package expression.typedExpressions;

import expression.Evaluators.CommonEvaluator;

public class TypedMin<T> extends TypedBinaryOperation<T> {
    
    public TypedMin(TypedBothExpressions<T> first, TypedBothExpressions<T> second, CommonEvaluator<T> evaluator) {
        super(first, second, evaluator);
    }

    public T getRes(T first, T second) {
        return evaluator.min(first, second);
    }
}
