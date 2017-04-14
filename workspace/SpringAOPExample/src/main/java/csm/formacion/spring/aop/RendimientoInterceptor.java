/**
 * 
 */
package csm.formacion.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


public class RendimientoInterceptor implements MethodInterceptor {

	/*
	 * (non-Javadoc)
	 * @see org.aopalliance.intercept.MethodInterceptor#invoke(org.aopalliance.intercept.MethodInvocation)
	 */
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// medida de tiempo inicial
		long t0 = System.currentTimeMillis();
		
		// invocacion del metodo interceptado
		Object resultado = invocation.proceed();
		
		// trazas del tiempo de ejecucion del metodo
		long t1 = System.currentTimeMillis();
		System.out.println("La invocación del metodo "
				+ invocation.getMethod().getName() + " ha durado " + (t1 - t0)
				+ " ms.");
		
		// es necesario devolver el resultado de la invocacion
		return resultado;
	}
}
