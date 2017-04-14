/**
 * 
 */
package csm.formacion.spring.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;


public class LogBeforeAdvice implements MethodBeforeAdvice {

	/* (non-Javadoc)
	 * @see org.springframework.aop.MethodBeforeAdvice#before(java.lang.reflect.Method, java.lang.Object[], java.lang.Object)
	 */
	public void before(Method method, Object[] argumentos, Object target)
			throws Throwable {
		System.out.println("Llamada al metodo " + method.getName());
	}
}
