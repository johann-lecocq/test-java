package fr.johannlecocq.testjava.scripting;

import fr.johannlecocq.testjava.scripting.exceptions.CalculatorCreationException;
import fr.johannlecocq.testjava.scripting.groovy.GroovyCalculatorFactory;
import fr.johannlecocq.testjava.scripting.interfaces.Calculator;
import fr.johannlecocq.testjava.scripting.interfaces.CalculatorFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by johann on 17/08/16.
 */
public class ScriptingGroovyTest {

    CalculatorFactory factory = new GroovyCalculatorFactory();

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
