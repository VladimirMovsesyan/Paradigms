"use strict"
let cnst = a => (x, y, z) => a
let variable = a => (x, y, z) => (a === "x" ? x : (a === "y" ? y : z))
let binOperation = (a, b) => (oper) => (x, y, z) => oper(a(x, y, z), b(x, y, z))
let add = (a, b) => binOperation(a, b)((x, y) => x + y)
let subtract = (a, b) => binOperation(a, b)((x, y) => x - y)
let multiply = (a, b) => binOperation(a, b)((x, y) => x * y)
let divide = (a, b) => binOperation(a, b)((x, y) => x / y)
let negate = (a) => (x, y, z) => -a(x, y, z)
let sinh = (a) => (x, y, z) => Math.sinh(a)
let cosh = (a) => (x, y, z) => Math.cosh(a)
let pi = (x, y, z) => cnst(Math.PI)
