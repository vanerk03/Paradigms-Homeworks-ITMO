package expression.Evaluators;

public interface CommonEvaluator<T> {
    T min(T first, T second);

    T max(T first, T second);

    T subtract(T first, T second);

    T add(T first, T second);

    T multiply(T first, T second);

    T divide(T first, T second);

    T variable(int first);

    T negate(T first);

    T intToType(int x);

    T count(T first);
}
