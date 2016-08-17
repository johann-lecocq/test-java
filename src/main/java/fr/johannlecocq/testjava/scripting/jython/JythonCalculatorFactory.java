package fr.johannlecocq.testjava.scripting.jython;

import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

import fr.johannlecocq.testjava.scripting.exceptions.CalculatorCreationException;
import fr.johannlecocq.testjava.scripting.interfaces.Calculator;
import fr.johannlecocq.testjava.scripting.interfaces.CalculatorFactory;

public class JythonCalculatorFactory implements CalculatorFactory {
    private static PyObject calculatorObject = null;

    private void initFactory() {
        synchronized (JythonCalculatorFactory.class) {
            if (calculatorObject == null) {
                PythonInterpreter interpreter = new PythonInterpreter();
                interpreter.exec("from Calculator import Calculator");
                calculatorObject = interpreter.get("Calculator");
            }
        }
    }

    public Calculator getCalculator() throws CalculatorCreationException {
        initFactory();
        PyObject calculatorObject = JythonCalculatorFactory.calculatorObject.__call__();
        return (Calculator) calculatorObject.__tojava__(Calculator.class);
    }
}
