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

function UnaryOperation(a, operation, sym) {
    return {
        value: a,
        evaluate: function(x, y, z) { return operation(this.value.evaluate(x, y, z)) },
        toString: function() { return (this.value.toString() + sym).trim() }
    }
}

function BinaryOperation(a, b, operation, sym) {
    return {
        operand1: a,
        operand2: b,
        evaluate: function(x, y, z) { return operation(this.operand1.evaluate(x, y, z), this.operand2.evaluate(x, y, z)) },
        toString: function() { return (this.operand1.toString() + " " + this.operand2.toString() + sym).trim() }
    }
}

// Binary operations
function Add(a, b) { return BinaryOperation(a, b, (u, v) => u + v, " + ") }
function Subtract(a, b) { return BinaryOperation(a, b, (u, v) => u - v, " - ") }
function Multiply(a, b) { return BinaryOperation(a, b, (u, v) => u * v, " * ") }
function Divide(a, b) { return BinaryOperation(a, b, (u, v) => u / v, " / ") }

// Unary operations
function Negate(a) { return UnaryOperation(a, (u) => -u, " negate ") }

// Available operations
let binaryOperationMap = {
    "+": Add,
    "-": Subtract,
    "*": Multiply,
    "/": Divide,
}

let unaryOperationMap = {
    "negate": Negate
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
        } else if (element === "negate") {
            stack.push(new unaryOperationMap[element](stack.pop()))
        } else {
            const operand2 = stack.pop()
            const operand1 = stack.pop()
            stack.push(new binaryOperationMap[element](operand1, operand2))
        }
    }
    return stack.pop()
}