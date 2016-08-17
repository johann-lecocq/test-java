package fr.johannlecocq.testjava.scripting.groovy;

import fr.johannlecocq.testjava.scripting.exceptions.CalculatorCreationException;
import fr.johannlecocq.testjava.scripting.interfaces.Calculator;
import fr.johannlecocq.testjava.scripting.interfaces.CalculatorFactory;
import fr.johannlecocq.testjava.scripting.javascript.JavascriptCalculatorFactory;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class GroovyCalculatorFactory implements CalculatorFactory {

    private static ScriptEngine scriptEngine = null;

    public Calculator getCalculator() throws CalculatorCreationException {
        Calculator calculator = null;
        try {
            initScriptEngine();
            calculator = (Calculator) scriptEngine.eval("new GroovyCalculator()");
        } catch (Exception e) {
            e.printStackTrace();
            throw new CalculatorCreationException();
        }
        return calculator;
    }

    private void initScriptEngine() throws FileNotFoundException, ScriptException {
        synchronized (JavascriptCalculatorFactory.class) {
            if (scriptEngine == null) {
                scriptEngine = new ScriptEngineManager().getEngineByName("groovy");
                scriptEngine.eval(new BufferedReader(new FileReader(getClass().getClassLoader().getResource("GroovyCalculator.groovy").getFile())));
            }
        }
    }

}
