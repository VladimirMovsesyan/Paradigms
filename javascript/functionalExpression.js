"use strict"
let cnst = a => (x, y, z) => a
let variable = a => (x, y, z) => (a === "x" ? x : (a === "y" ? y : z))
let binOperation = (a, b) => (oper) => (x, y, z) => oper(a(x, y, z), b(x, y, z))
let add = (a, b) => binOperation(a, b)((x, y) => x + y)
let subtract = (a, b) => binOperation(a, b)((x, y) => x - y)
let multiply = (a, b) => binOperation(a, b)((x, y) => x * y)
let divide = (a, b) => binOperation(a, b)((x, y) => x / y)
let negate = (a) => (x, y, z) => -a(x, y, z)
let PI = Math.PI
let E = Math.E;
