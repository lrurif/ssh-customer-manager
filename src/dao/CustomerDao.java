package dao;

import java.util.ArrayList;
import java.util.List;

import po.BaseDict;
import po.Customer;
public class CustomerDao extends DaoHibernate<Customer>{
	public List<Customer> findByPage(int page, int size) {
		String hql = "from Customer";
		return this.findPage(hql, page, size);
	}
	public List<BaseDict> findOrgin(String condition) {
//		String hql = "from BaseDict where dict_type_name = '客户来源' order by dict_item_name";
		String hql = "select u from BaseDict u where u.dict_type_name = ? order by dict_item_name";
		String param[] = {condition};
		return this.findCustomerOrigin(hql,param);
	}
	public List<Customer> findByCondition(String customerName, String customerOrigin, String industName, String customerLevel) {
		String hql = "select c from Customer c";
		ArrayList<String> params = new ArrayList<String>();
		int flag = 0;
		System.out.println(customerName);
		if(customerName!=null && !(customerName.equals("")) ) {
			hql +=" where c.cust_name like ?";
			flag =1;
			params.add("%" + customerName + "%");
		}
		if(customerOrigin!=null && !customerOrigin.equals("")) {
			if(flag ==1) {
				hql +=" and  ";
			}else {
				hql +=" where ";
				flag =1;
			}
			hql +="c.cust_source in (select u.dict_id from BaseDict u where u.dict_item_name = ?)";
			params.add(customerOrigin);
			
		}
		if(industName!=null && !industName.equals("")) {
			if(flag == 1) {
				hql +=" and  ";
			}else {
				hql +=" where ";
				flag =1;
			}
			hql+="c.cust_industry in (select u.dict_id from BaseDict u where u.dict_item_name = ?)";
			params.add(industName);
		}
		if(customerLevel!=null && !customerLevel.equals("")) {
			if(flag ==1) {
				hql +=" and  ";
			}else {
				hql +=" where ";
				flag =1;
			}
			hql += "c.cust_level in (select u.dict_id from BaseDict u where u.dict_item_name = ?)";
			params.add(customerLevel);
		}
		return this.findByConditionBase(hql, params, customerName, customerOrigin, industName, customerLevel);
	}
	public int addCustomer(String custName, String custSource, String custIndustry, String custLevel, String custLink,
			String custPhone, String custMobile, String custZip, String custAddress,String userId) {
		String sql = "INSERT INTO customer (`cust_name`, `cust_create_id`, `cust_source`, `cust_industry`, `cust_level`, `cust_linkman`, `cust_phone`, `cust_mobile`, `cust_zipcode`, `cust_address`, `cust_createtime`) VALUES ('"+custName+"', '"+userId+"', (select dict_id from base_dict where dict_type_name='客户信息来源' and dict_item_name = '"+custSource+"'), (select dict_id from base_dict where dict_type_name='客户行业' and dict_item_name = '"+custIndustry+"'), (select dict_id from base_dict where dict_type_name='客户级别' and dict_item_name = '"+custLevel+"'), '"+custLink+"', '"+custPhone+"', '"+custMobile+"', '"+custZip+"', '"+custAddress+"', now())";
		ArrayList<String> params = new ArrayList<String>();
		return this.insert(sql, params);
	}
	public int deleteCustomer(String custId) {
		String sql = "delete from customer where cust_id = '"+custId+"'";
		return this.delete(sql);
	}
	public int updateCustomer(String custId,String custName, String custSource, String custIndustry, String custLevel, String custLink,
			String custPhone, String custMobile, String custZip, String custAddress) {
		String sql = "update customer set cust_name = '"+custName+"',cust_source = (select dict_id from base_dict where dict_type_name='客户信息来源' and dict_item_name = '"+custSource+"'),cust_industry=(select dict_id from base_dict where dict_type_name='客户行业' and dict_item_name = '"+custIndustry+"'),cust_level=(select dict_id from base_dict where dict_type_name='客户级别' and dict_item_name = '"+custLevel+"'),cust_linkman='"+custLink+"',cust_phone='"+custPhone+"',cust_mobile='"+custMobile+"',cust_zipcode='"+custZip+"',cust_address='"+custAddress+"' where cust_id = '"+custId+"'";
		return this.update(sql);
	}
}
