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

public class Testito {

	
        public static final String ASDM_TEST_PATH = "uid___A002_X551c61_X1";
        
       
        

        public static void main (String[] args) throws ConversionException, IllegalAccessException, IOException {
                ASDM asdm = ASDM.getFromXML(ASDM_TEST_PATH);
                

                String csv = "test.csv";
                CSVWriter writer = new CSVWriter(new FileWriter(csv), ' ', CSVWriter.NO_QUOTE_CHARACTER);
                 

                Long Sum_exptime;
                Double lambda = 300000.0/1.0;
     
                
                
                       

                // Obtencion de ExecBlockTable
                ExecBlockTable execBlockTable = asdm.getExecBlock();
                ExecBlockRow execBlockRow;


                // Obtencion de FieldTable
                FieldTable fieldTable = asdm.getField();
                FieldRow fieldRow;


                // Obtencion de SourceTable
                SourceTable sourceTable = asdm.getSource();
                SourceRow sourceRow;



                // Obtencion de ScanTable
                 ScanTable scanTable = asdm.getScan();
                 

                // Obtencion de SubscanTable
                  SubscanTable subScanTable = asdm.getSubscan();
                  
                Obscore obscore = new Obscore ();

                        
                        
                for (ScanRow scanRow: scanTable.get()) {
                	execBlockRow = execBlockTable.getRowByKey(scanRow.getExecBlockId());

               	 	// obs_id 
                	obscore.setObs_id(execBlockRow.getExecBlockUID().toString());
                	
                	                	
// es opcional en   // target_name 
// en scantable
                	obscore.setTarget_name(scanRow.getSourceName().toString());

                    
                    // s_resolution 
                	obscore.setS_resolution( Double.toString(  (1.2 * lambda) /execBlockRow.getBaseRangeMax().get() ));
                    
                    
                	// t_min
                	obscore.setT_min(execBlockRow.getStartTime().toString());


                    // t_max
                	obscore.setT_max(execBlockRow.getEndTime().toString() );


                    // t_exptime
                	Sum_exptime = 0l;
                	
                    for (SubscanRow subScanRow: subScanTable.get()) {
                    	
                    	
                    	// si fila subcan pertenece a scan y al execblock
                    	if ( (subScanRow.getScanNumber() == scanRow.getScanNumber() )  &&  (subScanRow.getExecBlockId().getTagValue() == scanRow.getExecBlockId().getTagValue() )   ){
                    		
                    		if (subScanRow.getSubscanIntent() == SubscanIntent.ON_SOURCE  ) {
                    			
                    			Sum_exptime = Sum_exptime + (subScanRow.getEndTime().get() - subScanRow.getStartTime().get() );
                    			
                    		}
                    	}
                    }                    
                    obscore.setT_exptime(Long.toString(Sum_exptime) );


                    // em_min
                    obscore.setEm_min( execBlockRow.getBaseRangeMin().toString());


                    // em_max
                    obscore.setEm_max(execBlockRow.getBaseRangeMax().toString()); 

                
                    
                    
                    
                    
                    
                    
                   	
                    
                    
                    writer.writeNext(obscore.getRowObscore());
                    
                    

                     
                    
                }
                

                writer.close();
                
                System.out.println("OK");
        }   
}


