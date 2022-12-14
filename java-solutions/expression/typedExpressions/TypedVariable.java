package expression.typedExpressions;

import expression.Evaluators.CommonEvaluator;

public class TypedVariable<T> implements TypedBothExpressions<T> {
    private final String name;
    private final CommonEvaluator<T> evaluator;

    public TypedVariable(final String name, final CommonEvaluator<T> evaluator) {
        this.evaluator = evaluator;
        this.name = name;
    }

    public T evaluate(final int x) {
        return evaluator.variable(x);
    }

    public T evaluate(final int x, final int y, final int z) {
        return switch(name) {
            case("x") -> evaluator.variable(x);
            case("y") -> evaluator.variable(y);
            case("z") -> evaluator.variable(z);
            default -> null;  
        };
    }
}
