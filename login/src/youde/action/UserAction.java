package youde.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import youde.po.User;
import youde.service.UserService;

public class UserAction {

	private String userName;
	private String pwd;
	private UserService UserService;
	
	public void  login() {
		HttpServletResponse response =ServletActionContext.getResponse();
		User user=UserService.checklogin(userName,pwd);
		PrintWriter out;
		try {
			out = response.getWriter();
			if (user!=null) {
				out.write("1");
			}
			else {
				out.write("2");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


}
