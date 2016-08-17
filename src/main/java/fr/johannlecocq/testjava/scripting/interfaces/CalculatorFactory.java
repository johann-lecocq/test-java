package fr.johannlecocq.testjava.scripting.interfaces;

import fr.johannlecocq.testjava.scripting.exceptions.CalculatorCreationException;

/**
 * Created by johann on 03/11/15.
 */
public interface CalculatorFactory {
    Calculator getCalculator() throws CalculatorCreationException;
}
