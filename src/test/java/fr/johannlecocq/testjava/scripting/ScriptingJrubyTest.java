package fr.johannlecocq.testjava.scripting;

import fr.johannlecocq.testjava.scripting.exceptions.CalculatorCreationException;
import fr.johannlecocq.testjava.scripting.interfaces.Calculator;
import fr.johannlecocq.testjava.scripting.interfaces.CalculatorFactory;
import fr.johannlecocq.testjava.scripting.javascript.JavascriptCalculatorFactory;
import fr.johannlecocq.testjava.scripting.jruby.JrubyCalculatorFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by johann on 17/08/16.
 */
public class ScriptingJrubyTest {

    CalculatorFactory factory = new JrubyCalculatorFactory();


    @Test
    public void testAddition() throws CalculatorCreationException {
        Calculator calculator = factory.getCalculator();
        assertEquals(6,calculator.add(3,3));

    }
    @Test
    public void testSubtraction() throws CalculatorCreationException {
        Calculator calculator = factory.getCalculator();
        assertEquals(4,calculator.sub(12,8));
    }
    @Test
    public void testMultiplication() throws CalculatorCreationException {
        Calculator calculator = factory.getCalculator();
        assertEquals(36,calculator.mul(6,6));
    }
    @Test
    public void testDivision() throws CalculatorCreationException {
        Calculator calculator = factory.getCalculator();
        assertEquals(Float.valueOf(5f),Float.valueOf(calculator.div(25,5)));
    }
}
