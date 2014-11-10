import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;



/**
 * Clase encargada de manejar aquellas funciones auxiliares sobre el manejo de archivos y carpetas
 * necesarias para el proceso de conversion ASDM a CSV.
 * @author aguila
 *
 */
public class FileHandler {
	
	
 
    
    /**
     * Metodo que entrega la lista de carpetas al interior de un directorio
     * 
     * @param Path Ruta que se desea listar
     * @return String[] los nombres de las carpetas
     * @throws IOException
     */
       
    public static String [] listFolder (String Path) throws IOException{
        
    	String [] Folders = null;

    	ArrayList<String> arrayListFolder = new ArrayList<String>();
       
    	File Dir = new File(Path);	

    	
    	File [] listaArchivos = Dir.listFiles();
           
          	for (int i = 0; i < listaArchivos.length; i++) {

               if (listaArchivos[i].isDirectory()) {
                arrayListFolder.add(listaArchivos[i].getCanonicalPath());
               }
           }
           
        if ( !arrayListFolder.isEmpty() ) {
          	Folders = arrayListFolder.toArray(new String[arrayListFolder.size()]);
        }
           		
    
    	
    	return Folders;
    }
    
    
    
    /**
     * Metodo que obtiene la hora y fecha actual con el formato HH:mm:ss dd/MM/yyyy
     * 
     * @return String[] hora y fecha actual
     */
    
    public static String getDateHour () {
    	Date date = new Date();    	
   
    	DateFormat dateHourFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    	
    	return dateHourFormat.format(date);
    }
    
   
    
    /**
     * Metodo que entrega la lista de carpetas al interior de un directorio
     * 
     * @param ASDMname string que contiene el nombre del archivo asdm que se trabajo
     * @param FileLogName string que contiene el nombre del archivo log
     * @throws IOException
     */
    
    public static void make_log(String ASDMname, String FileLogName, String inicioProceso) throws IOException {
    	File file = new File(FileLogName);

    	FileWriter writer = new FileWriter(file,true);

    	/* Hora inicio, Hora final, Nombre datos ASDM*/
    	writer.append(inicioProceso + "\t" + getDateHour () + "\t" + ASDMname + "\n");


    	writer.close();
    	
    }
    
    
    
    
    

}
