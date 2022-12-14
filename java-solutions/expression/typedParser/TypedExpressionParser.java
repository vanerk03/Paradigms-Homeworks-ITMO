package expression.typedParser;

import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

import expression.Evaluators.CommonEvaluator;
import expression.typedExpressions.*;

public class TypedExpressionParser<T> extends BaseParser implements Parser<T> {

    private static final Set<Character> VARIABLE_NAMES = Set.of('x', 'y', 'z');

    // private final Supplier<TypedBothExpressions<T>> count = () -> count();
    private final Supplier<TypedBothExpressions<T>> minMax = this::minMax;
    private final Supplier<TypedBothExpressions<T>> addSubtract = this::addSubtract;
    private final Supplier<TypedBothExpressions<T>> multiplyDivide = this::multiplyDivide;
    private final Supplier<TypedBothExpressions<T>> varConst = this::varConst;
    private final CommonEvaluator<T> evaluator;

    private final Map<Supplier<TypedBothExpressions<T>>, Supplier<TypedBothExpressions<T>>> nextFunc = Map.of(
            minMax, addSubtract,
            addSubtract, multiplyDivide,
            multiplyDivide, varConst,
            varConst, minMax);

    public TypedExpressionParser(final CommonEvaluator<T> evaluator) {
        this.evaluator = evaluator;
    }
    
    public TypedBothExpressions<T> parse(final String s) {
        setSource(s);
        nextChar();
        return minMax();
    }

    // private TypedBothExpressions<T> count() {
    //     while (!eof()) {
    //         if (test("const")) {
    //             return new TypedCount<T>(varConst(), evaluator);
    //         } else {
    //             break;   
    //         }
    //     }
    //     return ;
    // }

    private TypedBothExpressions<T> minMax() {
        final Supplier<TypedBothExpressions<T>> lower = nextFunc.get(minMax);
        TypedBothExpressions<T> first = lower.get();

        while (!eof()) {

            if (test("m")) {
                if (test("in")) {
                    first = new TypedMin<>(first, lower.get(), evaluator);
                } else if (test("ax")) {
                    first = new TypedMax<>(first, lower.get(), evaluator);
                }
            } else {
                break;
            }
        }
        return first;
    }

    private TypedBothExpressions<T> addSubtract() {
        final Supplier<TypedBothExpressions<T>> lower = nextFunc.get(addSubtract);
        TypedBothExpressions<T> first = lower.get();

        while (!eof()) {
            if (test('+')) {
                first = new TypedAdd<>(first, lower.get(), evaluator);
            } else if (test('-')) {
                first = new TypedSubtract<>(first, lower.get(), evaluator);
            } else {
                break;
            }
        }
        return first;
    }

    private TypedBothExpressions<T> multiplyDivide() {
        final Supplier<TypedBothExpressions<T>> lower = nextFunc.get(multiplyDivide);
        TypedBothExpressions<T> first = lower.get();

        while (!eof()) {
            if (test('*')) {
                first = new TypedMultiply<>(first, lower.get(), evaluator);
            } else if (test('/')) {
                first = new TypedDivide<>(first, lower.get(), evaluator);
            } else {
                break;
            }
        }
        return first;
    }

    private TypedBothExpressions<T> varConst() {
        eof();

        if (isDigit()) {
            return parseConst(1);
        }
        // System.out.println(getSource());
        // System.out.println(getChar());
        // System.out.println(test("count"));
        if (test("count")) {
            test("(");
            final TypedBothExpressions<T> result = new TypedCount<>(minMax(), evaluator);
            test(")");
            return result;
        }

        if (test('(')) {
            final TypedBothExpressions<T> result = nextFunc.get(varConst).get();
            test(')');
            return result;
        }
        if (test('-')) {
            return parseMinus();
        }
        if (isLetter()) {
            return parseVariable();
        } 
        return new TypedConst<>(evaluator.intToType(0));
    }

    private TypedBothExpressions<T> parseMinus() {
        if (isDigit()) {
            return parseConst(-1);
        }
        return new TypedMinus<>(varConst(), evaluator);
    }

    private TypedBothExpressions<T> parseConst(final int sign) {
        int num = 0;
        while (!eof() && isDigit()) {
            num = num * 10 + sign * (getChar() - '0');
            nextChar();
        }
        return new TypedConst<>(evaluator.intToType(num));
    }

    private TypedBothExpressions<T> parseVariable() {

        final StringBuilder sb = new StringBuilder();
        while (!eof() && isLetter() && VARIABLE_NAMES.contains(getChar())) {
            sb.append(getChar());
            nextChar();
        }
        return new TypedVariable<>(sb.toString(), evaluator);
    }
}
