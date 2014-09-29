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
	  * Metodo que mueve (renombra la ruta) las carpetas de datos ASDM a otra carpeta que contiene las tablas ASDM
	  * que ya han sido procesadas
	  *  
	  * @param folderDataPath Ruta actual donde se encuentran los datos
	  * @param newFolderPath Ruta donde se desea mover los datos ya procesados
	  * @param newNameFolder Nombre de la carpeta que contendrá los datos ASDM correspondientes a una observación
	  * y que fueron convertidos a CSV
	  * @throws IOException
	  */
	
    public static void renameFolder (String folderDataPath, String newFolderPath) throws IOException {  
    				
		File asdmDataFolder = new File (folderDataPath);
        File dirProcesados = new File (newFolderPath );
        File dirNewName = new File( dirProcesados + "/" + asdmDataFolder.getName() );  
       
        
        if (!dirProcesados.exists()){
        	dirProcesados.mkdirs();
        }
        
        if ( asdmDataFolder.isDirectory()) {  
        	asdmDataFolder.renameTo(dirNewName);  
        } 
            
    }
    
    
    
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
    
    public static String getHourDate () {
    	Date date = new Date();    	
   
    	DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
    	
    	return hourdateFormat.format(date);
    }
    
   
    
    /**
     * Metodo que entrega la lista de carpetas al interior de un directorio
     * 
     * @param ASDMname string que contiene el nombre del archivo asdm que se trabajo
     * @param FileLogName string que contiene el nombre del archivo log
     * @throws IOException
     */
    
    public static void make_log(String ASDMname, String FileLogName) throws IOException {
    	File file = new File(FileLogName);

    	FileWriter writer = new FileWriter(file,true);

    	writer.append(getHourDate () + "\t" + ASDMname + "\n");


    	writer.close();
    	
    }
    
    
    
    
    

}
