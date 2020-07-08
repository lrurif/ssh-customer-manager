package service;

import java.util.List;

import po.User;

public interface UserService {
	public User findBynameAndPassword(User user);
}
