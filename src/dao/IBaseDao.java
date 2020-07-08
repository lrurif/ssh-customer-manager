package dao;

import java.util.*;


public interface IBaseDao<T>{
	public int insert(String sql,ArrayList<String> params);				//������o��ӵ����ݿ���
	public int update(String sql);				
	public int delete(String sql);				//�����ݿ���ɾ��һ����¼o
	public T findById(Class c,int id);			//����id����һ����¼
	public T findOne(String hql,String[] param); //��ѯ������¼
	public List<T> find(String hql,String[] param); //���������Ҷ�����¼
	public List<T> findPage(String hql,int page,int size); //��ҳ�������ж���
	public int getCount(String hql,String[] param); // �������ݸ���
	public List<T> findByFields(String hql,String fields[],String condition); //���ֶ�ģ������
}
