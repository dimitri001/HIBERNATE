/**
 * 
 */
package csm.formacion.spring.simple;


public interface IEcoService {
	
	/**
	 * Eco del mensaje. 
	 * @param mensaje
	 * @return
	 */
	public String eco(String mensaje);

	/**
	 * Eco del mensaje en mayusculas
	 * @param mensaje
	 * @return
	 */
	public String ecoMayusculas(String mensaje);
	
	/**
	 * Eco del mensaje sin espacios
	 * @param mensaje
	 * @return
	 * @throws EcoException 
	 */
	public String ecoTrimConExcepcion(String mensaje) throws EcoException;
}
