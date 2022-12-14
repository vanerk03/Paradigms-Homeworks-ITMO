package expression.typedExpressions;

import expression.Evaluators.CommonEvaluator;

public class TypedAdd<T> extends TypedBinaryOperation<T> {
    
    public TypedAdd(TypedBothExpressions<T> first, TypedBothExpressions<T> second, CommonEvaluator<T> evaluator) {
        super(first, second, evaluator);
    }

    public T getRes(T first, T second) {
        return evaluator.add(first, second);
    }
}
