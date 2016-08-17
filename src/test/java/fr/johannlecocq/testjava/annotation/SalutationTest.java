package fr.johannlecocq.testjava.annotation;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.assertEquals;

/**
 * Created by johann on 17/08/16.
 */
public class SalutationTest {

    @Test
    public void testSaluer() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Salutation salutation=new Salutation();
        assertEquals("Bonjour monsieur Jacques",Salutation.saluer(salutation,"Jacque"));
        assertEquals("Bonjour mademoiselle Noemie",Salutation.saluer(salutation,"Noemie"));
        assertEquals("Bonjour Toto",Salutation.saluer(salutation,"Toto"));
    }
}
