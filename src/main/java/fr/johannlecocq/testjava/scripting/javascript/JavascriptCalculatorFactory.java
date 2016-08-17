package fr.johannlecocq.testjava.scripting.javascript;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import fr.johannlecocq.testjava.scripting.exceptions.CalculatorCreationException;
import fr.johannlecocq.testjava.scripting.interfaces.Calculator;
import fr.johannlecocq.testjava.scripting.interfaces.CalculatorFactory;

/**
 * Created by johann on 09/11/15.
 */
public class JavascriptCalculatorFactory implements CalculatorFactory {

    private static ScriptEngine scriptEngine = null;

    public Calculator getCalculator() throws CalculatorCreationException {
        Calculator calculator = null;
        try {
            initScriptEngine();
            calculator = (Calculator) scriptEngine.eval("new Calculator()");
        } catch (Exception e) {
            e.printStackTrace();
            throw new CalculatorCreationException();
        }
        return calculator;
    }

    private void initScriptEngine() throws FileNotFoundException, ScriptException {
        synchronized (JavascriptCalculatorFactory.class) {
            if (scriptEngine == null) {
                scriptEngine = new ScriptEngineManager().getEngineByName("nashorn");
                scriptEngine.eval(new BufferedReader(new FileReader(getClass().getClassLoader().getResource("Calculator.js").getFile())));
            }
        }
    }
}
