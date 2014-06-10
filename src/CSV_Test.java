import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;

import au.com.bytecode.opencsv.CSV;
import au.com.bytecode.opencsv.CSVWriteProc;
import au.com.bytecode.opencsv.CSVWriter;



public class CSV_Test {
	
	private String RA_min;
	private String RA_max;
	private String DEC_min;
	private String DEC_max;
	private String E_V_I;
	private String A_V;
	private String A_I;
    

    private static final CSV csv = CSV
                    .separator(' ')
                    .noQuote()
                    .skipLines(1)
                    .charset("UTF-8")
                    .create();

    
    public void write() {
            String fileName = "test.csv";
            
            csv.write(fileName, new CSVWriteProc() {
                    public void process(CSVWriter output) {
                    	               
	                    	output.writeNext(getRA_min(),
	                    					getRA_max(),
	                    					getDEC_min(),
	                    					getDEC_max(),
	                    					getE_V_I(),
	                    					getA_V(),
	                    					getA_I()
	                    					);
                                   	
                            System.out.println(" OK ");
                    }
            });
            
    }


	public String getRA_min() {
		return RA_min;
	}


	public void setRA_min(String rA_min) {
		RA_min = rA_min;
	}


	public String getRA_max() {
		return RA_max;
	}


	public void setRA_max(String rA_max) {
		RA_max = rA_max;
	}


	public String getDEC_min() {
		return DEC_min;
	}


	public void setDEC_min(String dEC_min) {
		DEC_min = dEC_min;
	}


	public String getDEC_max() {
		return DEC_max;
	}


	public void setDEC_max(String dEC_max) {
		DEC_max = dEC_max;
	}


	public String getE_V_I() {
		return E_V_I;
	}


	public void setE_V_I(String e_V_I) {
		E_V_I = e_V_I;
	}


	public String getA_V() {
		return A_V;
	}


	public void setA_V(String a_V) {
		A_V = a_V;
	}


	public String getA_I() {
		return A_I;
	}


	public void setA_I(String a_I) {
		A_I = a_I;
	}
}