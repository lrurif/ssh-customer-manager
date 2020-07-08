package dao;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import po.BaseDict;
import po.Customer;

import org.hibernate.Query;

public class DaoHibernate<T> implements IBaseDao<T>{
	
	//ע��SessionFactory
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//����id����ִ�е�ʵ��
	@Override
	public T findById(Class c, int id) {
		return (T)sessionFactory.getCurrentSession().get(c, id);
	}

	//�����Զ���������һ��ʵ��
	public T findOne(String hql, String[] params) {
		Session s = sessionFactory.getCurrentSession();
		Query query = s.createQuery(hql);
		if(params!=null) {
			for(int i=0;i<params.length;i++) {
				query.setParameter(i, params[i]);
			}
		}
		return (T)query.uniqueResult();
	}

	//�����Զ���������ʵ�弯
	@Override
	public List<T> find(String hql, String[] params) {
		List<T> list = null;
		Session s = sessionFactory.getCurrentSession();
		Query query = s.createQuery(hql);
		if(params!=null) {
			for(int i=0;i<params.length;i++) {
				query.setParameter(i, params[i]);
			}
		}
		return query.list();
	}
	//��ҳ����ʵ�弯
	public List<T> findPage(String hql, int page, int size) {
		List<T> list = null;
		Session s = sessionFactory.getCurrentSession();
		Query query = s.createQuery(hql);
//		int start = (page-1)*size;
//		query.setFirstResult(start);
//		query.setMaxResults(size);
		list = query.list();
		return list;
	}
	@Override
	public int getCount(String hql, String[] param) {
		return 0;
	}
	@Override
	public List<T> findByFields(String hql, String[] fields, String condition) {
		String findhql = hql;
		if(fields!=null&&condition!=null&&fields.length>0&&!condition.contentEquals("")) {
			findhql = findhql + " where 1 = 1 and (";
			for(int i =0;i<fields.length;i++) {
				findhql += fields[i]+" like '%"+condition+"%'or ";
			}
			findhql += fields[fields.length-1] + " like '%" + condition + "%')";
			System.out.println(findhql);
		}
		Session s = sessionFactory.getCurrentSession();
		Query query = s.createQuery(findhql);
		List<T> list = query.list();
		return list;
	}
//	�������пͻ���Դ
	public List<BaseDict> findCustomerOrigin(String hql,String[] params) {
		List<BaseDict> list = null;
		Session s = sessionFactory.getCurrentSession();
		Query query = s.createQuery(hql);
		if(params!=null) {
			System.out.println(hql);
			for(int i=0;i<params.length;i++) {
				query.setParameter(i, params[i]);
			}
		}
		list = query.list();
		return list;
	}
//	������������ѯ����
	public List<Customer> findByConditionBase(String hql,ArrayList<String> params,String customerName, String customerOrigin, String industName, String customerLevel) {
		List<Customer> list = null;
		Session s = sessionFactory.getCurrentSession();
		Query query = s.createQuery(hql);
		if(params.size()!=0) {
			for(int i=0;i<params.size();i++) {
				query.setParameter(i, params.get(i));
				System.out.println(params.get(i));
			}
		}
		list = query.list();
		return list;
	}
	//����һ��ʵ��
	public int insert(String sql,ArrayList<String> params) {
		 Session s = sessionFactory.getCurrentSession();
		 Query query = s.createSQLQuery(sql);
		 if(params.size()>0) {
				for(int i=0;i<params.size();i++) {
					query.setParameter(i, params.get(i));
				}
			}
		 return query.executeUpdate();
	}
	public int delete(String sql) {
		Session s = sessionFactory.getCurrentSession();
		Query query = s.createSQLQuery(sql);
		return query.executeUpdate();
	}
	public int update(String sql) {
		Session s = sessionFactory.getCurrentSession();
		Query query = s.createSQLQuery(sql);
		return query.executeUpdate();
	}
}
