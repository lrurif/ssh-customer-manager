package service;

import java.util.List;

import po.Customer;
import po.BaseDict;
public interface CustomerService {
	public List<Customer> findByPage(int page, int size);
	public List<BaseDict> findOrgin(String condition);
	public List<Customer> findBycondition(String customerName, String customerOrigin, String industName, String customerLevel);
	public int addCustomer(String custName,String custSource,String custIndustry,String custLevel,String custLink,String custPhone,String custMobile,String custZip,String custAddress,String userId);
	public int deleteCustomer(String custId);
	public int updateCusstomer(String custId,String custName, String custSource, String custIndustry, String custLevel, String custLink,
			String custPhone, String custMobile, String custZip, String custAddress);
}
