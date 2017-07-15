package reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import wrappers.LeafTapsWrapper;

public class LearnRef {
	
	public static void main(String[] args) {
		
		//Syntax
		//Class<ClassName> obj = ClassName.class
		
		Class<LeafTapsWrapper> wrapper = LeafTapsWrapper.class;
		Method[] allmethods = wrapper.getMethods();
		
		for (Method eachMethod : allmethods) {
			System.out.println(eachMethod.getName());	
		//	System.out.println(eachMethod.getModifiers());			
		}
		
		Constructor<?>[] allCons= wrapper.getDeclaredConstructors();
		for (Constructor<?> eachConstructor : allCons) {
			System.out.println(eachConstructor.getName());	
			System.out.println(eachConstructor.getModifiers());
		}
		
		Annotation[] allAnn= wrapper.getDeclaredAnnotations();
		System.out.println(allAnn.length);
		for (Annotation eachAnnotation: allAnn) {
			System.out.println(eachAnnotation);	
			
		}
		
	}

}










