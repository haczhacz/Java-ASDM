import alma.asdm.ASDM;
import alma.asdm.ExecBlockTable;
import alma.asdm.FieldRow;
import alma.asdm.FieldTable;
import alma.asdm.ScanRow;
import alma.asdm.ScanTable;
import alma.asdm.SourceRow;
import alma.asdm.ExecBlockRow;
import alma.asdm.SourceTable;
import alma.hla.runtime.asdm.ex.ConversionException;
import alma.hla.runtime.asdm.ex.InvalidAccessException;
import alma.hla.runtime.asdm.ex.NoSuchRow;

public class Testito {

	
        public static final String ASDM_TEST_PATH = "uid___A002_X551c61_X1";
        
/*
        private static final CSV csv = CSV
                .separator(' ')
                .noQuote()
                .skipLines(1)
                .charset("UTF-8")
                .create();
        
        private static final String fileName = "test.csv";
*/       

        

                
        

        public static void main (String[] args) throws ConversionException, IllegalAccessException {
                ASDM asdm = ASDM.getFromXML(ASDM_TEST_PATH);

                
     
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

                        
                        
                for (ScanRow scanRow: scanTable.get()) {
                	execBlockRow = execBlockTable.getRowByKey(scanRow.getExecBlockId());

               	 	// obs_id 
                   System.out.println(execBlockRow.getExecBlockUID());
                	
                	                	
// es opcional en     // target_name 
// en scantable
                    System.out.println(scanRow.getSourceName());

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


