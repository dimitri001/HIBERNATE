/**
 * 
 */
package csm.formacion.spring.simple;


public class EcoServiceImpl implements IEcoService {
	private IMayusculasService mayusculasService;
	private String prefijoMensaje;

	/* (non-Javadoc)
	 * @see csm.formacion.spring.simple.IEcoService#eco(java.lang.String)
	 */
	public String eco(String mensaje) {
		return prefijoMensaje + mensaje;
	}

	/* (non-Javadoc)
	 * @see csm.formacion.spring.simple.IEcoService#ecoMayusculas(java.lang.String)
	 */
	public String ecoMayusculas(String mensaje) {
		return prefijoMensaje + mayusculasService.convertir(mensaje);
	}
	
	/*
	 * (non-Javadoc)
	 * @see csm.formacion.spring.simple.IEcoService#ecoTrimConExcepcion(java.lang.String)
	 */
	public String ecoTrimConExcepcion(String mensaje) throws EcoException {
		if (mensaje == null) {
			throw new EcoException("mensaje nulo");
		}
		
		return mensaje.trim();
	}

	public IMayusculasService getMayusculasService() {
		return mayusculasService;
	}

	public void setMayusculasService(IMayusculasService mayusculasService) {
		this.mayusculasService = mayusculasService;
	}

	public String getPrefijoMensaje() {
		return prefijoMensaje;
	}

	public void setPrefijoMensaje(String prefijoMensaje) {
		this.prefijoMensaje = prefijoMensaje;
	}

}
