package service.impl;
import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import po.BaseDict;
import po.Customer;
import service.CustomerService;
import dao.CustomerDao;
public class CustomerServiceImpl implements CustomerService{
	CustomerDao customerDao;
	@Transactional(propagation=Propagation.REQUIRED,rollbackForClassName="Exception")
	public List<Customer> findByPage(int page, int size) {
		return customerDao.findByPage(page, size);
	}
	@Transactional(propagation=Propagation.REQUIRED,rollbackForClassName="Exception")
	public List<BaseDict> findOrgin(String condition) {
		return customerDao.findOrgin(condition);
	}
	@Transactional(propagation=Propagation.REQUIRED,rollbackForClassName="Exception")
	public List<Customer> findBycondition(String customerName, String customerOrigin, String industName, String customerLevel) {
		return customerDao.findByCondition(customerName, customerOrigin, industName,customerLevel);
	}
	@Transactional(propagation=Propagation.REQUIRED,rollbackForClassName="Exception")
	public int addCustomer(String custName, String custSource, String custIndustry, String custLevel, String custLink,
			String custPhone, String custMobile, String custZip, String custAddress,String userId) {
		return customerDao.addCustomer(custName, custSource, custIndustry, custLevel, custLink, custPhone, custMobile, custZip, custAddress,userId);
	}
	@Transactional(propagation=Propagation.REQUIRED,rollbackForClassName="Exception")
	public int deleteCustomer(String custId) {
		return customerDao.deleteCustomer(custId);
	}
	@Transactional(propagation=Propagation.REQUIRED,rollbackForClassName="Exception")
	public int updateCusstomer(String custId, String custName, String custSource, String custIndustry, String custLevel,
			String custLink, String custPhone, String custMobile, String custZip, String custAddress) {
		return customerDao.updateCustomer(custId, custName, custSource, custIndustry, custLevel, custLink, custPhone, custMobile, custZip, custAddress);
	}
	public CustomerDao getCustomerDao() {
		return customerDao;
	}
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
	
	

}
