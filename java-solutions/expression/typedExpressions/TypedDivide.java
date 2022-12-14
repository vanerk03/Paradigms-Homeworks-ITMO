package expression.typedExpressions;

import expression.Evaluators.CommonEvaluator;

public class TypedDivide<T> extends TypedBinaryOperation<T> {
    
    public TypedDivide(TypedBothExpressions<T> first, TypedBothExpressions<T> second, CommonEvaluator<T> evaluator) {
        super(first, second, evaluator);
    }

    public T getRes(T first, T second) {
        return evaluator.divide(first, second);
    }
}
