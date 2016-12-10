package youde.dao;

import youde.po.User;

public interface UserDAO {

	User checklogin(String username, String pwd);
}
