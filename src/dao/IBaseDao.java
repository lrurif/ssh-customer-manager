package dao;

import java.util.*;


public interface IBaseDao<T>{
	public int insert(String sql,ArrayList<String> params);				//将对象o添加到数据库内
	public int update(String sql);				
	public int delete(String sql);				//从数据库中删除一个记录o
	public T findById(Class c,int id);			//利用id查找一条记录
	public T findOne(String hql,String[] param); //查询单条记录
	public List<T> find(String hql,String[] param); //按条件查找多条记录
	public List<T> findPage(String hql,int page,int size); //分页查找所有对象
	public int getCount(String hql,String[] param); // 返回数据个数
	public List<T> findByFields(String hql,String fields[],String condition); //单字段模糊查找
}
