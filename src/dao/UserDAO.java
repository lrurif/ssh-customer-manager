package dao;

import po.User;
public class UserDAO extends DaoHibernate<User>{
	public User findBynameAndPassword(User user) {
		String hql = "from User u where u.user_code = ? and u.user_password = ?";
		String param[] = {user.getUser_code(),user.getUser_password()};
		User user1 = this.findOne(hql,param);
		return user1;
	}
}
