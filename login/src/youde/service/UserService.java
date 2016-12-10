package youde.service;

import youde.po.User;

public interface UserService {

	User checklogin(String username, String pwd);

}
