/**
 * 
 */
package csm.formacion.spring.simple;


public class MayusculasServiceImpl implements IMayusculasService {

	/* (non-Javadoc)
	 * @see csm.formacion.spring.simple.IMayusculasService#convertir(java.lang.String)
	 */
	public String convertir(String mensaje) {
/*		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			// nada que hacer
		}*/
		return mensaje != null ? mensaje.toUpperCase() : null;
	}

}
