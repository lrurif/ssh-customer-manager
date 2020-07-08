package action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import po.User;
import service.UserService;

public class UserAction {

	UserService userService;
	private User user;
	List<User> users;
	private HttpSession session;
	public String userLogin() {
		User user2 = userService.findBynameAndPassword(user);
		session = ServletActionContext.getRequest().getSession();
		if(user2!=null) {
			session.setAttribute("userId", user2.getUser_id());
			session.setAttribute("userName", user2.getUser_name());
			session.setAttribute("loginFail", "");
			return "success";
		}
		session.setAttribute("loginFail", true);
		return "fail";
	}
	public String userLoginOut() {
		session = ServletActionContext.getRequest().getSession();
		session.setAttribute("userId", null);
		session.setAttribute("userName", null);
		return "success";
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}


}
