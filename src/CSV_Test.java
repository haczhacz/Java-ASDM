import au.com.bytecode.opencsv.CSV;
import au.com.bytecode.opencsv.CSVWriteProc;
import au.com.bytecode.opencsv.CSVWriter;



public class CSV_Test {
    

    private static final CSV csv = CSV
                    .separator(' ')
                    .noQuote()
                    .skipLines(1)
                    .charset("UTF-8")
                    .create();


    
    public static void main(String[] args) {
            String fileName = "test.csv";
            

            csv.write(fileName, new CSVWriteProc() {
                    public void process(CSVWriter out) {
                            out.writeNext("RA_min", "RA_max", "DEC_min", "DEC_max", "E(V-I)", "A_V", "A_I");             
                            out.writeNext("78.910625", "78.982146", "-69.557417", "-69.480639", "-0.04", "0.092571", "0.123429");

                        	
                            System.out.println(" OK ");
                    }
            });
            
    }
}