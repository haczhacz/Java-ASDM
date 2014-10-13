import java.io.IOException;

import alma.hla.runtime.asdm.ex.ConversionException;



/**
 * Clase encargada de hacer la conversion ASDM a CSV, obteniendo los datos desde las tablas ASDM
 * 
 * @author hcalquin
 *
 */
public class Launcher {
	
	/**
	 * @param args recibe la ruta en donde se encuentran los archivos asdm a procesar
	 */
	 public static void main (String[] args) throws IllegalAccessException, IOException, ConversionException {
		 
		ASDMCsvConverter aplicacion = new ASDMCsvConverter();
		System.out.println("------ " + args[0]);
		aplicacion.start(args[0]);
		 
		 
	 }

}
