var CalculatorType = Java.type("fr.johannlecocq.testjava.scripting.interfaces.Calculator");

var Calculator = Java.extend(CalculatorType, {
        add: function (i, j) {
            return i + j;
        },
        mul: function (i, j) {
            return i * j;
        },
        sub: function (i, j) {
            return i - j;
        },

        div: function (i, j) {
            return i / j;
        }
    }
);