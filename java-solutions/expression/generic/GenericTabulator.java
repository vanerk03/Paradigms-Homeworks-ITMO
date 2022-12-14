package expression.generic;

import expression.Evaluators.*;
import expression.typedExpressions.TypedBothExpressions;
import expression.typedParser.Parser;
import expression.typedParser.TypedExpressionParser;

public class GenericTabulator implements Tabulator {
    public Object[][][] tabulate(final String mode, final String expression, final int x1, final int x2, final int y1,
            final int y2, final int z1, final int z2)
            throws Exception {

        CommonEvaluator<?> evaluator;

        switch (mode) {
            case "i" -> {
                evaluator = new CheckedEvaluator();
            }
            case "d" -> {
                evaluator = new DoubleEvaluator();
            }
            case "bi" -> {
                evaluator = new BigIntegerEvaluator();
            }
            default -> throw new IllegalArgumentException("this flag ain't supported");
        }

        final Parser<?> parser = new TypedExpressionParser<>(evaluator);
        final TypedBothExpressions<?> expr = parser.parse(expression);

        final Object[][][] res = new Object[x2 - x1 + 1][y2 - y1 + 1][z2 - z1 + 1];
        for (int i = 0; i <= x2 - x1; i++) {
            for (int j = 0; j <= y2 - y1; j++) {
                for (int k = 0; k <= z2 - z1; k++) {
                    try {
                        res[i][j][k] = expr.evaluate(x1 + i, y1 + j, z1 + k);
                    } catch (OverflowException | ArithmeticException e) {
                        res[i][j][k] = null;
                    }
                }
            }
        }
        return res;
    }
}