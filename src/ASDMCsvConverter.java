import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import alma.SubscanIntentMod.SubscanIntent;
import alma.asdm.ASDM;
import alma.asdm.ScanRow;
import alma.asdm.ScanTable;
import alma.asdm.SourceRow;
import alma.asdm.ExecBlockRow;
import alma.asdm.SourceTable;
import alma.asdm.SubscanRow;
import alma.asdm.SubscanTable;
import alma.hla.runtime.asdm.ex.ConversionException;
import au.com.bytecode.opencsv.CSVWriter;




/**
 * Clase encargada de hacer la conversion ASDM a CSV, obteniendo los datos desde las tablas ASDM
 * 
 * @author aguila
 *
 */
public class ASDMCsvConverter {
		
		public static String NOMBRE_CARPETA_PROCESADOS = "Procesados";
	
		
		
		/**
		 * 
		 * @param args Ruta de la carpeta que contiene los datos ASDM (arg[0]) y 
		 * Ruta de la carpeta en la cual se desea almacenar los archivos CSV con los datos Obscore (args[1])
		 * @throws ConversionException
		 * @throws IOException
		 * @throws IllegalAccessException
		 */
        public static void main (String[] args) throws ConversionException, IOException, IllegalAccessException {
        	
        	// validas para eclipse
        	String ASDM_INPUT_DATA_PATH = "./ASDMData/";
    	 	String ASDM_OUTPUT_DATA_PATH = "./CSV/";
          	
    	 	
    	 	
        	// maneja el caso que se ejecute por bash
        	if (args.length == 2) {
        	 	ASDM_INPUT_DATA_PATH = args[0];
        	 	ASDM_OUTPUT_DATA_PATH = args[1];
        	}
          	
        
        	
        	String[] listaCarpetas =  FileHandler.listFolder(ASDM_INPUT_DATA_PATH);
        	File asdmDataFolder;
        
        	
        	
    		// verifica y crea carpeta CSV de output
    		File folder = new File(ASDM_OUTPUT_DATA_PATH);
    		if (!folder.exists()) {
    			folder.mkdirs();    			
    		}
    		

			
    		
    		for (String Folder: listaCarpetas) {
    			asdmDataFolder = new File (Folder);
    			
                String csv = ASDM_OUTPUT_DATA_PATH + asdmDataFolder.getName() + ".csv";
                
                
                
                ASDM asdm = ASDM.getFromXML(ASDM_INPUT_DATA_PATH + asdmDataFolder.getName());
                
                
                
                CSVWriter writer = new CSVWriter(new FileWriter(csv), ' ', CSVWriter.NO_QUOTE_CHARACTER);
               

                Long sumExptime;
                Double vSpeedLight = 300000.0;
                Double lambda;
     
                
                
                       
                ExecBlockRow execBlockRow;


                // Obtencion de SourceTable
                SourceTable sourceTable = asdm.getSource();



                // Obtencion de ScanTable
                 ScanTable scanTable = asdm.getScan();
                 

                // Obtencion de SubscanTable
                  SubscanTable subScanTable = asdm.getSubscan();
                  
                ObscoreRow obscoreRow = new ObscoreRow ();

                String sourceName;   
                        
                for (ScanRow scanRow: scanTable.get()) {
                	execBlockRow = scanRow.getExecBlockUsingExecBlockId();

               	 	// obs_id 
                	obscoreRow.setObs_id(execBlockRow.getExecBlockUID().getEntityId().toString());
                	
                	
                	lambda = vSpeedLight / execBlockRow.getSBSummaryUsingSBSummaryId().getFrequency();
                	
                	                	
                	if ( scanRow.isSourceNameExists() ) {							// comprueba que sourceName exista (es opcional en scanTable)
                		
                		sourceName = scanRow.getSourceName().replace(" ", "_");
                    	// target_name 													// es opcional  en scantable
                    		
                		obscoreRow.setTarget_name( sourceName );
                                        	
                        // s_ra
                    	// s_dec
                    	for (SourceRow sourceRow: sourceTable.get()) {													// busca en la tabla source 
                    		if (sourceRow.getSourceName().equals(sourceName)) {											// si alguno coincide con el sourceName
                    			
                    			obscoreRow.setS_ra(sourceRow.getDirection()[0].toString());								// s_ra
                    			obscoreRow.setS_dec(sourceRow.getDirection()[1].toString());							// s_dec
                    			

                    		    break;																					// basta solo encontrar uno
                    			
                    		}
                    	}                		
                	}
                	else {
                		// ver como rellenar campos si no existe
                		obscoreRow.setTarget_name("-");
                		obscoreRow.setS_ra("0");							
            			obscoreRow.setS_dec("0");		
                		
                	}
                	                	
                	
                    // s_resolution 
                	obscoreRow.setS_resolution( Double.toString(  (1.2 * lambda) /execBlockRow.getBaseRangeMax().get() ));
                    
                    
                	// t_ms_fovin
                	obscoreRow.setT_min(execBlockRow.getStartTime().toString());


                    // t_max
                	obscoreRow.setT_max(execBlockRow.getEndTime().toString() );


                    // t_exptime
                	sumExptime = 0l;
                	
                    for (SubscanRow subScanRow: subScanTable.get()) {
                    	
                    	
                    	// si fila subcan pertenece a scan y al execblock
                    	if ( (subScanRow.getScanNumber() == scanRow.getScanNumber() )  &&  (subScanRow.getExecBlockId().getTagValue() == scanRow.getExecBlockId().getTagValue() )   ){
                    		
                    		if (subScanRow.getSubscanIntent() == SubscanIntent.ON_SOURCE  ) {
                    			
                    			sumExptime = sumExptime + (subScanRow.getEndTime().get() - subScanRow.getStartTime().get() );
                    			
                    		}
                    	}
                    }                    
                    obscoreRow.setT_exptime(Long.toString(sumExptime) );


                    // em_min
                    obscoreRow.setEm_min( execBlockRow.getBaseRangeMin().toString());


                    // em_max
                    obscoreRow.setEm_max(execBlockRow.getBaseRangeMax().toString()); 

                

                    
                    
                    writer.writeNext(obscoreRow.getObscoreRow());
                    
                    
                    
                   
                    
                }
                

                writer.close();
                
                System.out.println("OK");

                
                
                // se mueve a carpeta procesados
    			FileHandler.renameFolder(asdmDataFolder.getCanonicalPath(), asdmDataFolder.getParent(), NOMBRE_CARPETA_PROCESADOS);
                                
    		}
    		
                
        }   

        
        
        
        
        
        
        
        
       
        
        
        
      
        
}



