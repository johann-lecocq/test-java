package fr.johannlecocq.testjava.scripting.jruby;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import fr.johannlecocq.testjava.scripting.exceptions.CalculatorCreationException;
import fr.johannlecocq.testjava.scripting.interfaces.Calculator;
import fr.johannlecocq.testjava.scripting.interfaces.CalculatorFactory;

public class JrubyCalculatorFactory implements CalculatorFactory {

    private static ScriptEngine scriptEngine = null;

    public Calculator getCalculator() throws CalculatorCreationException {
        Calculator calculator = null;
        try {
            initScriptEngine();
            calculator = (Calculator) scriptEngine.eval("Calculator.new");
        } catch (Exception e) {
            e.printStackTrace();
            throw new CalculatorCreationException();
        }
        return calculator;
    }

    private void initScriptEngine() throws FileNotFoundException, ScriptException {
        synchronized (JrubyCalculatorFactory.class) {
            if (scriptEngine == null) {
                scriptEngine = new ScriptEngineManager().getEngineByName("jruby");
                scriptEngine.eval(new BufferedReader(new FileReader(getClass().getClassLoader().getResource("Calculator.rb").getFile())));
            }
        }
    }


}
