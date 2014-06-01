import alma.asdm.ASDM;
import alma.asdm.ASDMTable;
import alma.asdm.AntennaRow;
import alma.asdm.AntennaTable;
import alma.asdm.MainRow;
import alma.asdm.SourceRow;
import alma.asdm.MainTable;
import alma.asdm.ExecBlockRow;
import alma.hla.runtime.asdm.ex.ConversionException;


public class Testito {

        public static final String ASDM_TEST_PATH = "uid___A002_X551c61_X1";

        public static void main (String[] args) throws ConversionException {
                ASDM asdm = ASDM.getFromXML(ASDM_TEST_PATH);

                /*
                for (SourceRow row: asdm.getSource().get()) {
                        //System.out.println(row.getSourceName());
                }
				*/



                for (ExecBlockRow row: asdm.getExecBlock().get()) {

                    row.getAntennaId();

                    //AntennaTable antenna_table = asdm.getAntenna().getRowByKey(row.getAntennaId());
                



                    // obs_id
                    System.out.println(row.getExecBlockUID());


                    // t_min
                    System.out.println(row.getStartTime());
                    
                    // t_max
                    System.out.println(row.getEndTime());



                    // em_min
                    System.out.println(row.getBaseRangeMin());


                    // em_max
                    System.out.println(row.getBaseRangeMax());


                }





        }
}



                
