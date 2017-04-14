/**
 * 
 */
package csm.formacion.spring.aop;

import org.springframework.aop.ThrowsAdvice;

import csm.formacion.spring.simple.EcoException;


public class EcoExceptionAdvice implements ThrowsAdvice {
	/**
	 * Captura las excepciones del servicio eco y lanza en su lugar
	 * excepciones de la aplicacion.
	 * @param e
	 * @throws AplicacionException
	 */
	public void afterThrowing(EcoException e) throws AplicacionException {
		throw new AplicacionException(e.getMessage());
	}
}
