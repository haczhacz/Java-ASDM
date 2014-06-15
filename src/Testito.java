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
     
                // Campos estaticos
                String dataproduct_type = "visibility";
               	String calib_level = "1";
                String obs_collection = "ALMA";
                String s_region = "circle";
                String o_ucd = "em.mm";
                String facility_name = "ALMA";
                String instrument_name = "ALMA";
                
                       

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

                        
                        
                for (ScanRow scanRow: scanTable.get()) {
                	execBlockRow = execBlockTable.getRowByKey(scanRow.getExecBlockId());

               	 	// obs_id 
                   System.out.println(execBlockRow.getExecBlockUID());
                	
                	                	
// es opcional en   // target_name 
// en scantable
                    System.out.println(scanRow.getSourceName());

                    
                    // s_resolution 
                    System.out.println( (1.2f * lambda) /execBlockRow.getBaseRangeMax().get());
                    
                    
                	// t_min
                    System.out.println(execBlockRow.getStartTime());


                    // t_max
                    System.out.println(execBlockRow.getEndTime());


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
                    System.out.println(Sum_exptime);


                    // em_min
                    System.out.println(execBlockRow.getBaseRangeMin());


                    // em_max
                    System.out.println(execBlockRow.getBaseRangeMax());

                
                    
                    
                    
                    
                    
                    ArrayList<String> arraylist = new ArrayList<String>();
                    
                    
                    arraylist.add(dataproduct_type);
                    arraylist.add(calib_level);
                    arraylist.add(obs_collection);
                    arraylist.add(s_region);
                    arraylist.add(o_ucd);
                    arraylist.add(facility_name);
                    arraylist.add(instrument_name);

                    String [] country = arraylist.toArray(new String[arraylist.size()]);
                   	
                    
                    
                    writer.writeNext(country);
                    
                    

                     
                    
                }
                

                writer.close();
        }   
}


