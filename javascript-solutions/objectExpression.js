"use strict";

class Func {
    constructor(lmbd, arity, func) {
        this.lmbd = lmbd;
        this.arity = arity;
        this.func = func;
    };
}

function Variable(nm) {
    this.nm = nm;
}

function Const(value) {
    this.value = value;
}

function AbstractExpression(...args) {
    this.args = args;
}

function Constructor() {
    return function (...args) { AbstractExpression.call(this, ...args); }
}

function exprConstructor(sign) {
    let oper = Constructor();
    oper.prototype = Object.create(AbstractExpression.prototype)
    oper.prototype.sign = sign;
    return oper;
}

const Max5 = exprConstructor("max5");
const Min3 = exprConstructor("min3");
const Sinh = exprConstructor("sinh");
const Cosh = exprConstructor("cosh");
const Negate = exprConstructor("negate");
const Add = exprConstructor("+");
const Subtract = exprConstructor("-");
const Multiply = exprConstructor("*");
const Divide = exprConstructor("/");


const signTry = {
    "max5": new Func((...args) => Math.max(...args), 5, Max5),
    "min3": new Func((...args) => Math.min(...args), 3, Min3),
    "cosh": new Func((a) => Math.cosh(a), 1, Cosh),
    "sinh": new Func((a) => Math.sinh(a), 1, Sinh),
    "negate": new Func((a) => -a, 1, Negate),
    "+": new Func((a, b) => a + b, 2, Add),
    "-": new Func((a, b) => a - b, 2, Subtract),
    "/": new Func((a, b) => a / b, 2, Divide),
    "*": new Func((a, b) => a * b, 2, Multiply)
}

function prototypeSetter(nm, prefix, toString, evaluate) {
    nm.prototype.prefix = prefix;
    nm.prototype.toString = toString;
    nm.prototype.evaluate = evaluate;
}

prototypeSetter(AbstractExpression,
    function () {
        let res = this.sign;
        for (const x of this.args) {
            res += " " + x.prefix();
        }
        return "(" + res + ")";
    },

    function () {
        let res = "";
        for (const x of this.args) {
            res += x.toString() + " ";
        }
        res += this.sign;
        return res;
    },
    function (...args) {
        return signTry[this.sign].lmbd(...this.args.map(val => val.evaluate(...args)))
    }
)

prototypeSetter(Variable,
    function () {
        return this.nm;
    },
    function () {
        return this.nm;
    },
    function (...args) {
        return args[variables[this.nm]];
    },
)

prototypeSetter(Const,
    function () {
        return this.value.toString();
    },
    function () {
        return this.value.toString();
    },
    function (x, y, z) {
        return this.value;
    },
)

const variables = { "x": 0, "y": 1, "z": 2 };

function parse(expression) {
    let st = [];

    for (let elem of expression.trim().split(/\s+/)) {
        if (elem in variables) {
            st.push(new Variable(elem));
        }
        else if (elem in signTry) {
            const elemOperation = signTry[elem].func;
            const numberOfArguments = -signTry[elem].arity;
            st.push(new elemOperation(...st.splice(numberOfArguments)));
        }
        else {
            st.push(new Const(parseInt(elem)));
        }
    }
    return st.splice(-1)[0];
}

function ParseError(message) {
    Error.call(this, message);
    this.message = message;
}

function EofError(message) {
    ParseError.call(this, message);
    this.message = message;
}

function errorSetter(name, prototypeName, strName) {
    name.prototype = Object.create(prototypeName.prototype);
    name.prototype.constructor = name;
    name.prototype.name = strName;
}

errorSetter(ParseError, Error, "ParseError");
errorSetter(EofError, ParseError, "EofError");

class PrefixParser {
    constructor() {
        this.expression;
        this.i = -1;
    }

    nextChar() {
        const res = this.getChar();
        this.i += 1;
        return res;
    }

    next() {
        this.ignore();
        let res = "";
        while (!this.eof() && !(this.getChar() == " ") && !(this.getChar() == "(") && !(this.getChar() == ")")) {
            res += this.nextChar();
        }
        return res;
    }

    nextInt() {
        const res = this.next();
        for (let x of res) {
            if (!this.isDigit(x)) {
                throw new ParseError(x + " is not a digit");
            }
        }
        return parseInt(res);
    }

    getChar() {
        if (!this.eof()) { return this.expression[this.i]; }
        else {
            throw new EofError("Expression is not complete");
        }
    }

    test(string) {
    // :NOTE:/2 wouldn't work on strings of size > 1
        for (let i = 0; i < string.length; i++) {
            if (!(string[i] == this.getChar())) { return false; }
            this.nextChar();
        }
        return true;
    }

    ignore() {
        while (!this.eof() && this.getChar() === " ") { this.nextChar(); }
    }

    eof() { return this.i === this.expression.length; }

    isDigit(x) { return ('0' <= x && x <= '9') || (x === '-'); }

    getExpression(string) {
        this.expression = string;
        this.i = 0;
        const res = this.getTop();
        this.ignore();
        if (!this.eof()) {
            throw new ParseError("Expression is incorrect");
        }
        return res;
    }

    getTop() {
        this.ignore()

        if (this.test("(")) {
            const res = this.getExpr();
            this.ignore()
            if (!(this.nextChar() === ")")) {
                throw new ParseError("expected ) at position " + this.i);
            }
            return res;
        }
        else if (this.isDigit(this.getChar())) {
            return this.getConst();
        }
        else if (this.getChar() in variables) {
            return this.getVar();
        }
        throw new ParseError("Unknown symbol found at " + this.i);
    }

    getVar() {
        const nm = this.next();
        if (!(nm in variables)) { throw new ParseError("invalid variable name"); }
        return new Variable(nm);
    }

    getConst() { return new Const(this.nextInt()); }

    getExpr() {
        const expr = this.next();
        if (expr in signTry && (this.getChar() == " " || this.getChar() == "(")) {
            const ar = signTry[expr].arity;
            let lst = []
            for (let i = 0; i < ar; i++) {
                this.ignore();
                lst.push(this.getTop());
            }
            return new signTry[expr].func(...lst);
        }
        throw new ParseError("Operation is invalid at symbol" + this.i);
    }
}

const parser = new PrefixParser();
function parsePrefix(string) {
    // console.log(string);
    return parser.getExpression(string);
}