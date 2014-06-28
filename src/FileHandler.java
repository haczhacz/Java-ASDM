import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class FileHandler {
	
	
	  
    /*
     * Mueve las carpetas procesadas a una nueva carpeta con nombre pasado por parametro
     * y a una ruta pasada por parametro
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
