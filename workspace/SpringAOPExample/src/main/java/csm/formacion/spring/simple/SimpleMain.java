/**
 * 
 */
package csm.formacion.spring.simple;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;


public class SimpleMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
				
		ApplicationContext context = new ClassPathXmlApplicationContext("contexto.xml");
		
		IEcoService ecoService = (IEcoService) context.getBean("ecoService");
		
		String mensaje = "Hola Mundo!";
		System.out.println(ecoService.eco(mensaje));
		System.out.println(ecoService.ecoMayusculas(mensaje));
	}
}
