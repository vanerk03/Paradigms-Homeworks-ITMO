package expression.typedParser;

import expression.typedExpressions.TypedBothExpressions;

public interface Parser<T> {
    TypedBothExpressions<T> parse(String s);
}
