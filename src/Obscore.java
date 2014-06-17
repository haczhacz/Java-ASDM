
public class Obscore {
	
	//Datos obscore
    private String dataproduct_type;                
   	private String calib_level;
    private String obs_collection;
    private String obs_id;
    private String target_name;
    private String s_ra;
    private String s_dec;
    private String s_fov;
    private String s_region;
    private String s_resolution;
    private String t_min;
    private String t_max;
    private String t_exptime;
    private String t_resolution;
    private String em_min;
    private String em_max;
    private String em_res_power;
    private String o_ucd;
    private String pol_states;
    private String facility_name;
    private String instrument_name;
    
    
    
    
    public Obscore ( ) {
    	this.dataproduct_type = "visibility";
    	this.calib_level = "1";
    	this.obs_collection = "ALMA";
    	this.s_region = "circle";
    	this.o_ucd = "em.mm";
    	this.facility_name = "ALMA";
    	this.instrument_name = "ALMA";   	
    }
    
    
    
    
    
    
    
    
    
	public String getDataproduct_type() {
		return dataproduct_type;
	}
	public void setDataproduct_type(String dataproduct_type) {
		this.dataproduct_type = dataproduct_type;
	}
	public String getCalib_level() {
		return calib_level;
	}
	public void setCalib_level(String calib_level) {
		this.calib_level = calib_level;
	}
	public String getObs_collection() {
		return obs_collection;
	}
	public void setObs_collection(String obs_collection) {
		this.obs_collection = obs_collection;
	}
	public String getObs_id() {
		return obs_id;
	}
	public void setObs_id(String obs_id) {
		this.obs_id = obs_id;
	}
	public String getTarget_name() {
		return target_name;
	}
	public void setTarget_name(String target_name) {
		this.target_name = target_name;
	}
	public String getS_ra() {
		return s_ra;
	}
	public void setS_ra(String s_ra) {
		this.s_ra = s_ra;
	}
	public String getS_dec() {
		return s_dec;
	}
	public void setS_dec(String s_dec) {
		this.s_dec = s_dec;
	}
	public String getS_fov() {
		return s_fov;
	}
	public void setS_fov(String s_fov) {
		this.s_fov = s_fov;
	}
	public String getS_region() {
		return s_region;
	}
	public void setS_region(String s_region) {
		this.s_region = s_region;
	}
	public String getS_resolution() {
		return s_resolution;
	}
	public void setS_resolution(String s_resolution) {
		this.s_resolution = s_resolution;
	}
	public String getT_min() {
		return t_min;
	}
	public void setT_min(String t_min) {
		this.t_min = t_min;
	}
	public String getT_max() {
		return t_max;
	}
	public void setT_max(String t_max) {
		this.t_max = t_max;
	}
	public String getT_exptime() {
		return t_exptime;
	}
	public void setT_exptime(String t_exptime) {
		this.t_exptime = t_exptime;
	}
	public String getT_resolution() {
		return t_resolution;
	}
	public void setT_resolution(String t_resolution) {
		this.t_resolution = t_resolution;
	}
	public String getEm_min() {
		return em_min;
	}
	public void setEm_min(String em_min) {
		this.em_min = em_min;
	}
	public String getEm_max() {
		return em_max;
	}
	public void setEm_max(String em_max) {
		this.em_max = em_max;
	}
	public String getEm_res_power() {
		return em_res_power;
	}
	public void setEm_res_power(String em_res_power) {
		this.em_res_power = em_res_power;
	}
	public String getO_ucd() {
		return o_ucd;
	}
	public void setO_ucd(String o_ucd) {
		this.o_ucd = o_ucd;
	}
	public String getPol_states() {
		return pol_states;
	}
	public void setPol_states(String pol_states) {
		this.pol_states = pol_states;
	}
	public String getFacility_name() {
		return facility_name;
	}
	public void setFacility_name(String facility_name) {
		this.facility_name = facility_name;
	}
	public String getInstrument_name() {
		return instrument_name;
	}
	public void setInstrument_name(String instrument_name) {
		this.instrument_name = instrument_name;
	}
    
    
    
    
    
    
    
    
    
    
    
    
	
	

}
