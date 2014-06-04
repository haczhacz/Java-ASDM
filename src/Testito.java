import alma.asdm.ASDM;
import alma.asdm.AntennaRow;
import alma.asdm.AntennaTable;
import alma.asdm.ExecBlockTable;
import alma.asdm.FeedTable;
import alma.asdm.FieldRow;
import alma.asdm.FieldTable;
import alma.asdm.MainRow;
import alma.asdm.ReceiverRow;
import alma.asdm.ReceiverTable;
import alma.asdm.SourceRow;
import alma.asdm.ExecBlockRow;
import alma.asdm.SourceTable;
import alma.hla.runtime.asdm.ex.ConversionException;


public class Testito {

        public static final String ASDM_TEST_PATH = "uid___A002_X551c61_X1";

        public static void main (String[] args) throws ConversionException, IllegalAccessException {
                ASDM asdm = ASDM.getFromXML(ASDM_TEST_PATH);

                
                
                // Obtencion de ExecBlockTable
        		ExecBlockTable execBlockTable = asdm.getExecBlock();
        		ExecBlockRow execBlockRow;
        		
        		/*
                // Obtencion de FieldTable
        		FieldTable fieldTable = asdm.getField();
        		FieldRow fieldRow;
                */
        		        		       
        		
        		
                for (MainRow mainRow: asdm.getMain().get()) {
                	
                	System.out.println("-----------");
                                		                	
                	
                /*MAIN TABLE */
                	
	            		//access_estsize
	            		System.out.println(mainRow.getDataSize());
	            		
	            	
	            		//t_exptime
	            		System.out.println(mainRow.getInterval());
	            		
            		
	            		
	            		
	            	/*EXECBLOCK TABLE */
		                	execBlockRow = execBlockTable.getRowByKey(mainRow.getExecBlockId());
		                	
		            		// obs_id
		                    System.out.println(execBlockRow.getExecBlockUID());
		                    
		                    
		                    // t_min
		                    System.out.println(execBlockRow.getStartTime());
		                    
		           
		                    // t_max
		                    System.out.println(execBlockRow.getEndTime());
		
		
		                    // em_min
		                    System.out.println(execBlockRow.getBaseRangeMin());
		
		
		                    // em_max
		                    System.out.println(execBlockRow.getBaseRangeMax());
		                    

		                    	                    
                }


        }
}



                
