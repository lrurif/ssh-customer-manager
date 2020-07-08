package service.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.UserDAO;
import po.User;
import service.UserService;

public class UserServiceImpl implements UserService {

	UserDAO userDAO;


	@Transactional(propagation=Propagation.REQUIRED,rollbackForClassName="Exception")
	public User findBynameAndPassword(User user) {
		User user1 = userDAO.findBynameAndPassword(user);
		return user1;
	}
	public UserDAO getUserDAO() {
		return userDAO;
	}


	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	
}
