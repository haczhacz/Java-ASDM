import java.io.File;
import java.io.IOException;
import java.util.ArrayList;



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
	
    public static void renameFolder (String folderDataPath, String newFolderPath, String newNameFolder) throws IOException {  
    				
		File asdmDataFolder = new File (folderDataPath);
        File dirProcesados = new File (newFolderPath + "/" + newNameFolder  + "/" );
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
    
    /*
     * Lee el directorio, seleccionando solo las carpetas
     * Carpeta debe contener los datos ASDM
     */        
    public static String [] listFolder (String Path) throws IOException{
        
    	ArrayList<String> arrayListFolder = new ArrayList<String>();
       
    	File Dir = new File(Path);	
    	File [] listaArchivos = Dir.listFiles();
           
          	for (int i = 0; i < listaArchivos.length; i++) {

               if (listaArchivos[i].isDirectory()) {
                arrayListFolder.add(listaArchivos[i].getCanonicalPath());
               }
           }
           
       String [] Folders = arrayListFolder.toArray(new String[arrayListFolder.size()]);
           
       return Folders;
    }
    
    
    

}
