import java.io.IOException;

import alma.hla.runtime.asdm.ex.ConversionException;


public class Launcher {
	
	 public static void main (String[] args) throws IllegalAccessException, IOException, ConversionException {
		 
		ASDMCsvConverter aplicacion = new ASDMCsvConverter();
		aplicacion.start(args[0], args[1]);
		 
		 
	 }

}
