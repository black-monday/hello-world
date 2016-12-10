package youde.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import youde.dao.UserDAO;
import youde.po.User;

public class UserDAOImpl implements UserDAO{
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public UserDAOImpl() {
	}
	@Override
	public User checklogin(String username, String pwd) {
		Session session=sessionFactory.getCurrentSession();
		String hql="select u from User u where u.userName=:userName and u.pwd=:pwd";
		Query query=session.createQuery(hql);
		query.setString("userName", username);
		query.setString("pwd", pwd);
		@SuppressWarnings("unchecked")
		List<User> list=query.list();
		if (list==null||list.size()==0) {
			return null;
		}
		return list.get(0);
	}

}
