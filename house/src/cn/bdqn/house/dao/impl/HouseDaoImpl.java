package cn.bdqn.house.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.bdqn.house.dao.HouseDao;
import cn.bdqn.house.entity.District;
import cn.bdqn.house.entity.House;
import cn.bdqn.house.entity.HouseType;
import cn.bdqn.house.entity.Street;
import cn.bdqn.house.util.PageBean;

public class HouseDaoImpl extends HibernateDaoSupport implements HouseDao {

	@Override
	public void save(House house) {
		super.getHibernateTemplate().getSessionFactory().getCurrentSession().save(house);
	}
    
	@Override
	public void update(House house) {
		super.getHibernateTemplate().getSessionFactory().getCurrentSession().update(house);
		
	}

	@Override
	public void delete(House house) {
		super.getHibernateTemplate().getSessionFactory().getCurrentSession().delete(house);
		
	}
    
	@Override
	public House getById(Serializable id) {
		// TODO Auto-generated method stub
		return (House) super.getHibernateTemplate().getSessionFactory().getCurrentSession().get(House.class, id);
	}

	

	@Override
	public List<House> getList() {
		return super.getHibernateTemplate().find("from House");
	}
	public List<House> getList(String querycondition,int pageIndex,int pageSize){
		
		StringBuilder hql=new StringBuilder("from House where 1=1");
		if(null!=querycondition&&!"".equals(querycondition)){
			hql.append(" and title like :title");
		}
		Query query=super.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql.toString());
		query.setFirstResult(pageIndex);
		query.setMaxResults(pageSize);
		if(null!=querycondition&&!"".equals(querycondition)){
			query.setString("title", "%"+querycondition+"%");
			return query.list();
		}else{
			return query.list();
		}
		
		
	}
	public int getCount(String querycondition){
		StringBuilder hql=new StringBuilder("select count(id) from House where 1=1");
		if(null!=querycondition&&!"".equals(querycondition)){
			hql.append(" and title like :title");
		}
		Query query=super.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql.toString());
		if(null!=querycondition&&!"".equals(querycondition)){
			//下面这个set语句比较重点容易忘记
			query.setString("title", "%"+querycondition+"%");
			Object obj=query.uniqueResult();
			return Integer.parseInt(obj.toString());
		}else{
			Object obj=query.uniqueResult();
			return Integer.parseInt(obj.toString());
		}
	}

	@Override
	public List<HouseType> findHouseType() {
		// TODO Auto-generated method stub
		return super.getHibernateTemplate().find("from HouseType");
	}

	@Override
	public List<District> findDistrict() {
		// TODO Auto-generated method stub
		return super.getHibernateTemplate().find("from District");
	}

	@Override
	public List<Street> findStreetListByDisId(int disId) {
		// TODO Auto-generated method stub
		return (List<Street>)super.getHibernateTemplate().find("from Street where district.id=?", disId);
	}
	
}
