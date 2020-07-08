package action;
import service.CustomerService;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Hibernate;

import po.Customer;
import po.BaseDict;
public class CustomerAction {
	CustomerService customerService;
	private List<Customer> customerList;
	private List<BaseDict> originList;
	private List<BaseDict> industList;
	private List<BaseDict> levelList;
	private HttpSession session;
	public String getByPage() {
		session = ServletActionContext.getRequest().getSession();
		String page = ServletActionContext.getRequest().getParameter("page");
		int realPage = Integer.valueOf(page);
		customerList = customerService.findByPage(realPage, 10);
		originList = customerService.findOrgin("客户信息来源");
		industList = customerService.findOrgin("客户行业");
		levelList = customerService.findOrgin("客户级别");
		session.setAttribute("totalPage", (customerList.size()/10)+1);
		if(realPage*10>=customerList.size()) {
			customerList = customerList.subList((realPage-1)*10, customerList.size());
		}else {
			customerList = customerList.subList((realPage-1)*10, realPage*10);
		}
		session.setAttribute("currentPage", realPage);
		
		for(Customer customer :customerList) {
			customer.setCust_source_str(customer.getCust_source_obj().getDict_item_name());
			customer.setCust_industry_str(customer.getCust_industry_obj().getDict_item_name());
			customer.setCust_level_str(customer.getCust_level_obj().getDict_item_name());
		}
		return "success";
	}
//	利用条件获取顾客列表
	public String getByCondition() {
		session = ServletActionContext.getRequest().getSession();
		String page = ServletActionContext.getRequest().getParameter("page");
		int realPage = Integer.valueOf(page);
		String customerName = ServletActionContext.getRequest().getParameter("customerName");
		String customerOrigin = ServletActionContext.getRequest().getParameter("custSource");
		String industName = ServletActionContext.getRequest().getParameter("custIndustry");
		String customerLevel = ServletActionContext.getRequest().getParameter("custLevel");
		customerList = customerService.findBycondition(customerName, customerOrigin, industName, customerLevel);
		originList = customerService.findOrgin("客户信息来源");
		industList = customerService.findOrgin("客户行业");
		levelList = customerService.findOrgin("客户级别");
		session.setAttribute("totalPage", Math.ceil(((float)customerList.size())/10));
		if(customerName == null) {
			session.setAttribute("customerName", "");
		}else {
			session.setAttribute("customerName", customerName);
		}
		session.setAttribute("customerOrigin", customerOrigin);
		session.setAttribute("industName", industName);
		session.setAttribute("customerLevel", customerLevel);
		if(realPage*10>=customerList.size()) {
			customerList = customerList.subList((realPage-1)*10, customerList.size());
		}else {
			customerList = customerList.subList((realPage-1)*10, realPage*10);
		}
		session.setAttribute("currentPage", realPage);
		for(Customer customer :customerList) {
			customer.setCust_source_str(customer.getCust_source_obj().getDict_item_name());
			customer.setCust_industry_str(customer.getCust_industry_obj().getDict_item_name());
			customer.setCust_level_str(customer.getCust_level_obj().getDict_item_name());
		}
		return "success";
	}
	public String addCustomer() {
		String userId = ServletActionContext.getRequest().getParameter("userId");
		String custName = ServletActionContext.getRequest().getParameter("custName");
		String custSource = ServletActionContext.getRequest().getParameter("custSource");
		String custIndustry = ServletActionContext.getRequest().getParameter("custIndustry");
		String custLevel = ServletActionContext.getRequest().getParameter("custLevel");
		String custLink = ServletActionContext.getRequest().getParameter("custLink");
		String custPhone = ServletActionContext.getRequest().getParameter("custPhone");
		String custMobile = ServletActionContext.getRequest().getParameter("custMobile");
		String custZip = ServletActionContext.getRequest().getParameter("custZip");
		String custAddress = ServletActionContext.getRequest().getParameter("custAddress");
		customerService.addCustomer(custName, custSource, custIndustry, custLevel, custLink, custPhone, custMobile, custZip, custAddress,userId);
		return "success";
	}
	public String deleteCustomer() {
		String custId = ServletActionContext.getRequest().getParameter("custId");
		customerService.deleteCustomer(custId);
		return "success";
	}
	public String updateCustomer() {
		String custId = ServletActionContext.getRequest().getParameter("custId");
		String custName = ServletActionContext.getRequest().getParameter("custName");
		String custSource = ServletActionContext.getRequest().getParameter("custSource");
		String custIndustry = ServletActionContext.getRequest().getParameter("custIndustry");
		String custLevel = ServletActionContext.getRequest().getParameter("custLevel");
		String custLink = ServletActionContext.getRequest().getParameter("custLink");
		String custPhone = ServletActionContext.getRequest().getParameter("custPhone");
		String custMobile = ServletActionContext.getRequest().getParameter("custMobile");
		String custZip = ServletActionContext.getRequest().getParameter("custZip");
		String custAddress = ServletActionContext.getRequest().getParameter("custAddress");
		customerService.updateCusstomer(custId, custName, custSource, custIndustry, custLevel, custLink, custPhone, custMobile, custZip, custAddress);
		return "success";
	}
	public CustomerService getCustomerService() {
		return customerService;
	}
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	public List<Customer> getCustomerList() {
		return customerList;
	}
	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}
	public HttpSession getSession() {
		return session;
	}
	public void setSession(HttpSession session) {
		this.session = session;
	}
	public List<BaseDict> getOriginList() {
		return originList;
	}
	public void setOriginList(List<BaseDict> originList) {
		this.originList = originList;
	}
	public List<BaseDict> getIndustList() {
		return industList;
	}
	public void setIndustList(List<BaseDict> industList) {
		this.industList = industList;
	}
	public List<BaseDict> getLevelList() {
		return levelList;
	}
	public void setLevelList(List<BaseDict> levelList) {
		this.levelList = levelList;
	}
	
	
}
