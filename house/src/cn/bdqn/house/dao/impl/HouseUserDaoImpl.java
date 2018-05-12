package cn.bdqn.house.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import cn.bdqn.house.dao.HouseUserDao;
import cn.bdqn.house.entity.HouseUser;

public class HouseUserDaoImpl extends HibernateDaoSupport implements HouseUserDao {

	
	public void save(HouseUser user) {
		super.getHibernateTemplate().save(user);
	}
    
	@Override
	public void update(HouseUser user) {
		super.getHibernateTemplate().getSessionFactory().getCurrentSession().update(user);
		
	}

	@Override
	public void delete(HouseUser user) {
		super.getHibernateTemplate().getSessionFactory().getCurrentSession().delete(user);
		
	}
    
	@Override
	public HouseUser getById(Serializable id) {
		// TODO Auto-generated method stub
		return (HouseUser) super.getHibernateTemplate().getSessionFactory().getCurrentSession().get(HouseUser.class, id);
	}

	@Override
	public HouseUser getByName(String userName) {
		  String hql="from HouseUser where username=:username";
	       Query query=super.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql);
	       query.setString("username",userName );
			return (HouseUser)query.uniqueResult();
	}

	@Override
	public List<HouseUser> getList() {
		return super.getHibernateTemplate().find("from HouseUser");
	}

}
