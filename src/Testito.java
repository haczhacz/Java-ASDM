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
     
                //Datos obscore
                String dataproduct_type = "visibility";                
               	String calib_level = "1";
                String obs_collection = "ALMA";
                String obs_id;
                String target_name;
                String s_ra;
                String s_dec;
                String s_fov;
                String s_region = "circle";
                String s_resolution;
                String t_min;
                String t_max;
                String t_exptime;
                String t_resolution;
                String em_min;
                String em_max;
                String em_res_power;
                String o_ucd = "em.mm";
                String pol_states;
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
                	obs_id = execBlockRow.getExecBlockUID().toString();
                	
                	                	
// es opcional en   // target_name 
// en scantable
                	target_name = scanRow.getSourceName().toString();

                    
                    // s_resolution 
                	s_resolution = Double.toString(  (1.2 * lambda) /execBlockRow.getBaseRangeMax().get() );
                    
                    
                	// t_min
                	t_min = execBlockRow.getStartTime().toString();


                    // t_max
                	t_max = execBlockRow.getEndTime().toString();


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
                    t_exptime = Long.toString(Sum_exptime);


                    // em_min
                    em_min = execBlockRow.getBaseRangeMin().toString();


                    // em_max
                    em_max = execBlockRow.getBaseRangeMax().toString();

                
                    
                    
                    
                    
                    
                    ArrayList<String> arraylist = new ArrayList<String>();
                    
                    // -> Para pruebas.
	                    s_ra = "s_ra";
	                    s_dec = "s_dec";
	                    s_fov = "s_fov";
	                    t_resolution = "t_resolution";
	                    em_res_power = "em_res_power";
	                    pol_states = "pol_states";
	                // <-
                    
                    arraylist.add(dataproduct_type);
                    arraylist.add(calib_level);
                    arraylist.add(obs_collection);
                    arraylist.add(obs_id);
                    arraylist.add(target_name);
                    arraylist.add(s_ra);
                    arraylist.add(s_dec);
                    arraylist.add(s_fov);
                    arraylist.add(s_region);
                    arraylist.add(s_resolution);
                    arraylist.add(t_min);
                    arraylist.add(t_max);
                    arraylist.add(t_exptime);
                    arraylist.add(t_resolution);
                    arraylist.add(em_min);
                    arraylist.add(em_max);
                    arraylist.add(em_res_power);  
                    arraylist.add(o_ucd);
                    arraylist.add(pol_states);
                    arraylist.add(facility_name);
                    arraylist.add(instrument_name);

                    


                    
                    
                    
                    
                    String [] rowObscore = arraylist.toArray(new String[arraylist.size()]);
                   	
                    
                    
                    writer.writeNext(rowObscore);
                    
                    

                     
                    
                }
                

                writer.close();
                
                System.out.println("OK");
        }   
}


