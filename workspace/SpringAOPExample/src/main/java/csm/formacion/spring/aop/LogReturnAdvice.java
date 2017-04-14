/**
 * 
 */
package csm.formacion.spring.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;


public class LogReturnAdvice implements AfterReturningAdvice {

	/* (non-Javadoc)
	 * @see org.springframework.aop.AfterReturningAdvice#afterReturning(java.lang.Object, java.lang.reflect.Method, java.lang.Object[], java.lang.Object)
	 */
	public void afterReturning(Object resultado, Method method, Object[] argumentos,
			Object target) throws Throwable {
		System.out.println("El metodo " + method.getName() + " ha devuelto " + resultado);
	}
}
