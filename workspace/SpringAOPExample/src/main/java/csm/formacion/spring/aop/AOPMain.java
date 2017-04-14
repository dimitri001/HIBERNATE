/**
 * 
 */
package csm.formacion.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import csm.formacion.spring.simple.IEcoService;


public class AOPMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("contexto.xml");
		IEcoService ecoService = (IEcoService) ctx.getBean("ecoService");
		String mensaje = "Hola Mundo!";
		System.out.println(ecoService.eco(mensaje));
		System.out.println("------");
		System.out.println(ecoService.ecoMayusculas(mensaje));
/*		String mensaje = "Hola Mundo!";
		System.out.println(ecoService.eco(mensaje));
		System.out.println("------");
		System.out.println(ecoService.ecoMayusculas(mensaje));
		System.out.println("------");
		try {
			System.out.println(ecoService.ecoTrimConExcepcion(null));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("------");
		IMayusculasService mayusculasService = (IMayusculasService) factory.getBean("mayusculasServiceAdviced");
		System.out.println(mayusculasService.convertir(mensaje));*/
	}
}
