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

function Add(a, b) {
    return {
        operand1: a,
        operand2: b,
        evaluate: function(x, y, z) { return this.operand1.evaluate(x, y, z) + this.operand2.evaluate(x, y, z) },
        toString: function() { return (this.operand1.toString() + " " + this.operand2.toString() + " + ").trim() }
    }
}

function Subtract(a, b) {
    return {
        operand1: a,
        operand2: b,
        evaluate: function(x, y, z) { return this.operand1.evaluate(x, y, z) - this.operand2.evaluate(x, y, z) },
        toString: function() { return (this.operand1.toString() + " " + this.operand2.toString() + " - ").trim() }
    }
}

function Multiply(a, b) {
    return {
        operand1: a,
        operand2: b,
        evaluate: function(x, y, z) { return this.operand1.evaluate(x, y, z) * this.operand2.evaluate(x, y, z) },
        toString: function() { return (this.operand1.toString() + " " + this.operand2.toString() + " * ").trim() }
    }
}

function Divide(a, b) {
    return {
        operand1: a,
        operand2: b,
        evaluate: function(x, y, z) { return this.operand1.evaluate(x, y, z) / this.operand2.evaluate(x, y, z) },
        toString: function() { return (this.operand1.toString() + " " + this.operand2.toString() + " / ").trim() }
    }
}

function Negate(a) {
    return {
        value: a,
        evaluate: function(x, y, z) { return -this.value.evaluate(x, y, z) },
        toString: function() { return (this.value.toString() + " negate ").trim() }
    }
}

let operationMap = {
    "+": Add,
    "-": Subtract,
    "*": Multiply,
    "/": Divide,
    "negate": Negate,
}

let variableList = "xyz"

function parse(a) {
    let arr = a.trim().split(/\s+/g)
    let stack = []
    for (const v of arr) {
        if (!isNaN(v)) {
            stack.push(new Const(parseInt(v)))
        } else if (variableList.includes(v)) {
            stack.push(new Variable(v))
        } else if (v === "negate") {
            stack.push(new operationMap[v](stack.pop()))
        } else {
            const operand2 = stack.pop()
            const operand1 = stack.pop()
            stack.push(new operationMap[v](operand1, operand2))
        }
    }
    return stack.pop()
}