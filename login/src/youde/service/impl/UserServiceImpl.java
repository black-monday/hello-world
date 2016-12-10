package youde.service.impl;

import org.springframework.transaction.annotation.Transactional;

import youde.dao.UserDAO;
import youde.po.User;
import youde.service.UserService;
@Transactional(rollbackFor=Exception.class)
public class UserServiceImpl implements UserService {
	private UserDAO UserDAO;
	public UserDAO getUserDAO() {
		return UserDAO;
	}
	public void setUserDAO(UserDAO userDAO) {
		UserDAO = userDAO;
	}
	public UserServiceImpl() {
	}
	@Override
	public User checklogin(String username, String pwd) {
		return UserDAO.checklogin(username,pwd);
	}

}
