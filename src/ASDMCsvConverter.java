import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import alma.SubscanIntentMod.SubscanIntent;
import alma.asdm.ASDM;
import alma.asdm.ExecBlockTable;
import alma.asdm.FieldRow;
import alma.asdm.FieldTable;
import alma.asdm.ScanRow;
import alma.asdm.ScanTable;
import alma.asdm.SourceRow;
import alma.asdm.ExecBlockRow;
import alma.asdm.SourceTable;
import alma.asdm.SubscanRow;
import alma.asdm.SubscanTable;
import alma.hla.runtime.asdm.ex.ConversionException;
import au.com.bytecode.opencsv.CSVWriter;

public class ASDMCsvConverter {

	
        public static void main (String[] args) throws ConversionException, IllegalAccessException, IOException {

        		String[] asdmFolderPath = listFolderASDMData();
        		
        		for (String asdmDataPath: asdmFolderPath) {
        			
        			
                    

                    String csv = asdmDataPath.toUpperCase();

                    System.out.println(csv);
                    
                    /*
                    ASDM asdm = ASDM.getFromXML(asdmDataPath);
                    CSVWriter writer = new CSVWriter(new FileWriter(csv), ' ', CSVWriter.NO_QUOTE_CHARACTER);
                     

                    Long sumExptime;
                    Double vSpeedLight = 300000.0;
                    Double lambda;
         
                    
                    
                           
                    ExecBlockRow execBlockRow;


                    // Obtencion de SourceTable
                    SourceTable sourceTable = asdm.getSource();
                    SourceRow sourceRow;



                    // Obtencion de ScanTable
                     ScanTable scanTable = asdm.getScan();
                     

                    // Obtencion de SubscanTable
                      SubscanTable subScanTable = asdm.getSubscan();
                      
                    ObscoreRow obscoreRow = new ObscoreRow ();

                            
                            
                    for (ScanRow scanRow: scanTable.get()) {
                    	execBlockRow = scanRow.getExecBlockUsingExecBlockId();

                   	 	// obs_id 
                    	obscoreRow.setObs_id(execBlockRow.getExecBlockUID().getEntityId().toString());
                    	
                    	
                    	lambda = vSpeedLight / execBlockRow.getSBSummaryUsingSBSummaryId().getFrequency();
                    	
                    	                	
    // es opcional en   // target_name 
    // en scantable
                    	obscoreRow.setTarget_name(scanRow.getSourceName().toString());

                        
                        // s_resolution 
                    	obscoreRow.setS_resolution( Double.toString(  (1.2 * lambda) /execBlockRow.getBaseRangeMax().get() ));
                        
                        
                    	// t_min
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
                    */
        			
        		}
                
        }   

        
        
        
        
        
        
        
        
        
        
        private static String [] listFolderASDMData () throws IOException{
        	
        	ArrayList<String> arrayListFolder = new ArrayList<String>();
        	
            File Dir = new File("./ASDMData");					
            File[] listaArchivos = Dir.listFiles();
            
            System.out.println ("Directorio actual: " + Dir.getCanonicalPath());
            
            for (int i = 0; i < listaArchivos.length; i++) {

                if (listaArchivos[i].isDirectory()) {
                	arrayListFolder.add(listaArchivos[i].getName());
                }
            }
            
            String [] Folders = arrayListFolder.toArray(new String[arrayListFolder.size()]);
            
			return Folders;
        }
}


