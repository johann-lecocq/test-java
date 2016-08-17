package fr.johannlecocq.testjava.annotation;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Salutation {
	
	@Genre("monsieur")
	public String saluerJacque(){
		return "Jacques";
	}

	@Genre("mademoiselle")
	public String saluerNoemie(){
		return "Noemie";
	}

    public String saluerToto(){
        return "Toto";
    }

	public static String saluer(Salutation salutation,String nom) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String resultat="Bonjour ";

	    Method methode=salutation.getClass().getMethod("saluer"+nom);

        Genre action=methode.getAnnotation(Genre.class);

        if(action!=null){
            resultat+=action.value()+" ";
        }

        Object[] o={};
        resultat+=methode.invoke(salutation, o);
        return resultat;
    }

}
