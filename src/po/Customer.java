package po;
import java.io.Serializable;
import java.util.Date;
import po.BaseDict;

public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	private int cust_id;         
	private String cust_name;        
//	private int cust_user_id;  
	private int cust_create_id;  
	private BaseDict cust_source_obj;      
	private BaseDict cust_industry_obj;    
	private BaseDict cust_level_obj;
	private String cust_linkman;     
	private String cust_phone;     
	private String cust_mobile;     
	private String cust_zipcode;    
	private String cust_address;   
	private Date cust_createtime;
	private int cust_source;
	private int cust_industry;
	private int cust_level;
	private String cust_source_str;
	private String cust_industry_str;
	private String cust_level_str;
//	private int start;           
//	private int rows;
	
	
	public String getCust_zipcode() {
		return cust_zipcode;
	}
	public void setCust_zipcode(String cust_zipcode) {
		this.cust_zipcode = cust_zipcode;
	}
	public String getCust_address() {
		return cust_address;
	}
	public void setCust_address(String cust_address) {
		this.cust_address = cust_address;
	}
//	public int getStart() {
//		return start;
//	}
//	public void setStart(int start) {
//		this.start = start;
//	}
//	public int getRows() {
//		return rows;
//	}
//	public void setRows(int rows) {
//		this.rows = rows;
//	}
	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
//	public int getCust_user_id() {
//		return cust_user_id;
//	}
//	public void setCust_user_id(int cust_user_id) {
//		this.cust_user_id = cust_user_id;
//	}
	public int getCust_create_id() {
		return cust_create_id;
	}
	public void setCust_create_id(int cust_create_id) {
		this.cust_create_id = cust_create_id;
	}

	public BaseDict getCust_source_obj() {
		return cust_source_obj;
	}
	public void setCust_source_obj(BaseDict cust_source_obj) {
		this.cust_source_obj = cust_source_obj;
	}
	public BaseDict getCust_industry_obj() {
		return cust_industry_obj;
	}
	public void setCust_industry_obj(BaseDict cust_industry_obj) {
		this.cust_industry_obj = cust_industry_obj;
	}
	public BaseDict getCust_level_obj() {
		return cust_level_obj;
	}
	public void setCust_level_obj(BaseDict cust_level_obj) {
		this.cust_level_obj = cust_level_obj;
	}
	public String getCust_linkman() {
		return cust_linkman;
	}
	public void setCust_linkman(String cust_linkman) {
		this.cust_linkman = cust_linkman;
	}
	public String getCust_phone() {
		return cust_phone;
	}
	public void setCust_phone(String cust_phone) {
		this.cust_phone = cust_phone;
	}
	public String getCust_mobile() {
		return cust_mobile;
	}
	public void setCust_mobile(String cust_mobile) {
		this.cust_mobile = cust_mobile;
	}
	public Date getCust_createtime() {
		return cust_createtime;
	}
	public void setCust_createtime(Date cust_createtime) {
		this.cust_createtime = cust_createtime;
	}
	public int getCust_source() {
		return cust_source;
	}
	public void setCust_source(int cust_source) {
		this.cust_source = cust_source;
	}
	public int getCust_industry() {
		return cust_industry;
	}
	public void setCust_industry(int cust_industry) {
		this.cust_industry = cust_industry;
	}
	public int getCust_level() {
		return cust_level;
	}
	public void setCust_level(int cust_level) {
		this.cust_level = cust_level;
	}
	public String getCust_source_str() {
		return cust_source_str;
	}
	public void setCust_source_str(String cust_source_str) {
		this.cust_source_str = cust_source_str;
	}
	public String getCust_industry_str() {
		return cust_industry_str;
	}
	public void setCust_industry_str(String cust_industry_str) {
		this.cust_industry_str = cust_industry_str;
	}
	public String getCust_level_str() {
		return cust_level_str;
	}
	public void setCust_level_str(String cust_level_str) {
		this.cust_level_str = cust_level_str;
	}

	
}
