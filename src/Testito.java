import alma.asdm.ASDM;
import alma.asdm.ConfigDescriptionTable;
import alma.asdm.ExecBlockTable;
import alma.asdm.FieldRow;
import alma.asdm.FieldTable;
import alma.asdm.MainRow;
import alma.asdm.SourceRow;
import alma.asdm.ExecBlockRow;
import alma.asdm.SourceTable;
import alma.asdm.SpectralWindowTable;
import alma.hla.runtime.asdm.ex.ConversionException;
import alma.hla.runtime.asdm.ex.InvalidAccessException;
import alma.hla.runtime.asdm.ex.NoSuchRow;
import alma.hla.runtime.asdm.types.Length;
import au.com.bytecode.opencsv.CSV;
import au.com.bytecode.opencsv.CSVWriteProc;
import au.com.bytecode.opencsv.CSVWriter;


public class Testito {

	
        public static final String ASDM_TEST_PATH = "uid___A002_X551c61_X1";
        

        private static final CSV csv = CSV
                .separator(' ')
                .noQuote()
                .skipLines(1)
                .charset("UTF-8")
                .create();
        
        private static final String fileName = "test.csv";
        

        

                
        

        public static void main (String[] args) throws ConversionException, IllegalAccessException, InvalidAccessException, NoSuchRow {
                ASDM asdm = ASDM.getFromXML(ASDM_TEST_PATH);

                
                csv.write(fileName, new CSVWriteProc() {
                	public void process(CSVWriter output) {
                		

	                	output.writeNext("RA_min", "RA_max", "DEC_min", "DEC_max", "E(V-I)", "A_V", "A_I");  
                
		                for (int i=0; i<3; i++) {
		           
		
		                	output.writeNext("78.910625", "78.982146", "-69.557417", "-69.480639", "-0.04", "0.092571", "0.123429");
		
		                }
                	}
                });
                
/*

                // Obtencion de ExecBlockTable
                        ExecBlockTable execBlockTable = asdm.getExecBlock();
                        ExecBlockRow execBlockRow;


                // Obtencion de FieldTable
                FieldTable fieldTable = asdm.getField();
                FieldRow fieldRow;


                // Obtencion de ConfigDescriptionTable
                        ConfigDescriptionTable configDescriptionTable = asdm.getConfigDescription();


                // Obtencion de SpectralWindowTable
                        SpectralWindowTable spectralWindowTable = asdm.getSpectralWindow();



                        // Campos estaticos
                        String dataproduct_type = "visibility";
                       	String calib_level = "1";
                        String obs_collection = "ALMA";
                        String access_url = "chivo.cl";
                        String access_format = "application/x-asdm";
                        String s_region = "circle";
                        String o_ucd = "em.mm";
                        String facility_name = "ALMA";
                        String instrument_name = "ALMA";




                // Obtencion de SourceTable
                        SourceTable sourceTable = asdm.getSource();
                        SourceRow sourceRow;


                for (MainRow mainRow: asdm.getMain().get()) {

                        System.out.println("-----------");


                //MAIN TABLE 

                                //access_estsize
                                System.out.println(mainRow.getDataSize());


                                
                                
                                
                                
                                
                                //t_exptime
                                System.out.println(mainRow.getInterval());


                                //EXECBLOCK TABLE 
                                        execBlockRow = execBlockTable.getRowByKey(mainRow.getExecBlockId());

                                        // obs_id
                                    System.out.println(execBlockRow.getExecBlockUID());


                                    // t_min
                                    System.out.println(execBlockRow.getStartTime());


                                    // t_max
                                    System.out.println(execBlockRow.getEndTime());

                                    System.out.println(execBlockRow.getEndTime());


                                    // em_min
                                    System.out.println(execBlockRow.getBaseRangeMin());


                                    Length baseRangeMax;
                                    // em_max
                                    baseRangeMax = execBlockRow.getBaseRangeMax();
                                    System.out.println(baseRangeMax);


// Completar
                                    // s_resolution
                                    System.out.println( " (1.2   * LAMBDA ) /   baseRangeMax   ");



                                //FIELD TABLE 

                                fieldRow = fieldTable.getRowByKey(mainRow.getFieldId());





// !!!! OJO QUE SOURCEID ES OPCIONAL EN LA TABLA FIELD !!!!!

                                // SOURCE TABLE 
                                sourceRow = fieldRow.getSources()[0];


                               	// s_ra
                                System.out.println(sourceRow.getDirection()[0]);

                                // s_dec
                                System.out.println(sourceRow.getDirection()[1]);


                                // pol_states
                                if (sourceRow.isStokesParameterExists() ) {
//Completar                                                                                                                                          $
                                       	sourceRow.getNumStokes();

                                }
                                else {
                                      	System.out.println("NULL");
                                }


                                // em_res_power

                                if (spectralWindowTable.getRowByKey(sourceRow.getSpectralWindowId()).isResolutionExists()) {
                                        System.out.println(spectralWindowTable.getRowByKey(sourceRow.getSpectralWindowId()).getResolution());


                                }
                                else {

//Ver que hacer en caso que no esta
                                        System.out.println("NULL");
                                }







                // obs_publisher_did
                        System.out.println(configDescriptionTable.getRowByKey( mainRow.getConfigDescriptionId() ).getSwitchCycleId() [0] );






                        
                        

*/
                
                
             
                
                
                        }       
                
                
               

              
                
	
	
}


