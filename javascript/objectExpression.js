"use strict"

function Const(a) { 
    return {
        value: a,
        evaluate: function(x, y, z) { return this.value },
        toString: function() { return this.value.toString() }
    } 
}

function Variable(a) {
    return {
        value: a,
        evaluate: function(x, y, z) { return (this.value === "x" ? x : (this.value === "y" ? y : z)) },
        toString: function() { return this.value } 
    }
}

function Operation(operation, sym, ...operands) {
    return {
        operands: operands,
        evaluate: function(x, y, z) { return operation(...this.operands.map(op => op.evaluate(x, y, z))) },
        toString: function() { return (this.operands.map(op => op.toString()).join(" ") + " " + sym).trim() }
    }
}

// Binary operations
function Add(a, b) { return Operation((u, v) => u + v, "+", a, b) }
function Subtract(a, b) { return Operation((u, v) => u - v, "-", a, b) }
function Multiply(a, b) { return Operation((u, v) => u * v, "*", a, b) }
function Divide(a, b) { return Operation((u, v) => u / v, "/", a, b) }

// Unary operations
function Negate(a) { return Operation((u) => (-u), "negate", a) }
function Sinh(a) { return Operation((u) => Math.sinh(u), "sinh", a) }
function Cosh(a) { return Operation((u) => Math.cosh(u), "cosh", a) }

// Available operations
let binaryOperationMap = {
    "+": Add,
    "-": Subtract,
    "*": Multiply,
    "/": Divide,
}

let unaryOperationMap = {
    "negate": Negate,
    "sinh": Sinh,
    "cosh": Cosh
}

// Available variables
let variableList = "xyz"

function parse(expression) {
    let elements = expression.trim().split(/\s+/g)
    let stack = []
    for (const element of elements) {
        if (!isNaN(element)) {
            stack.push(new Const(parseInt(element)))
        } else if (variableList.includes(element)) {
            stack.push(new Variable(element))
        } else if (element in unaryOperationMap) {
            stack.push(new unaryOperationMap[element](stack.pop()))
        } else {
            const operand2 = stack.pop()
            const operand1 = stack.pop()
            stack.push(new binaryOperationMap[element](operand1, operand2))
        }
    }
    return stack.pop()
}