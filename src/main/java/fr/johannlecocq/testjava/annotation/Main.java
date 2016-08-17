package fr.johannlecocq.testjava.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Salutation toto= new Salutation();
		
		for(Method m:toto.getClass().getDeclaredMethods()){
			Genre action=m.getAnnotation(Genre.class);
			
			if(action!=null){
				System.out.print(action.value()+" ");
			}
			
			Object[] o={};
			m.invoke(toto, o);
		}
	}

}
