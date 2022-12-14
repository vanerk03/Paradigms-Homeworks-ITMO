package expression;

public interface GenericExpression<T> {
    T evaluate(int x);
    
    T evaluate(int x, int y, int z);
}
