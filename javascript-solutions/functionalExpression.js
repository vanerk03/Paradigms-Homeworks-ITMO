"use strict";

const map1 =
{
    "x": 0,
    "y": 1,
    "z": 2
};

// const binaryFunc = f => (...args) => (...val) => f(...args.map(arg => arg(...val)));
const binaryFunc = (f, a, b) => (x, y, z) => f(a(x, y, z), b(x, y, z));

const add = (a, b) => binaryFunc((a, b) => a + b, a, b);
const subtract = (a, b) => binaryFunc((a, b) => a - b, a, b);
const divide = (a, b) => binaryFunc((a, b) => a / b, a, b);
const multiply = (a, b) => binaryFunc((a, b) => a * b, a, b);

const negate = (a) => (x, y, z) => -a(x, y, z);
const cnst = (a) => (x, y, z) => a;

const variable = (a) => (...args) => args[map1[a]];

const x = variable("x");
const one = cnst(1);
const two = cnst(2);
const e = (...args) => Math.E;
const pi = (...args) => Math.PI;

const testExpr = add(subtract(multiply(x, x), multiply(two, x)), one);

for (let i = 0; i <= 10; i++) {
    console.log(testExpr(i, 0, 0));
}