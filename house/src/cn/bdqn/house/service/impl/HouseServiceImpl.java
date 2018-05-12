package cn.bdqn.house.service.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Transaction;

import cn.bdqn.house.dao.HouseDao;
import cn.bdqn.house.entity.District;
import cn.bdqn.house.entity.House;
import cn.bdqn.house.entity.HouseType;
import cn.bdqn.house.entity.Street;
import cn.bdqn.house.service.HouseService;
import cn.bdqn.house.util.PageBean;

public class HouseServiceImpl implements HouseService {

	   private HouseDao houseDao;

	public HouseDao gethouseDao() {
		return houseDao;
	}

	public void sethouseDao(HouseDao houseDao) {
		this.houseDao = houseDao;
	}

	
	public void saveHouse(House user) {
		
			houseDao.save(user);
	
	}
     
	@Override
	public void updateHouse(House user) {
	
			houseDao.update(user);
	
	}

	@Override
	public void deleteHouse(House user) {
		
			houseDao.delete(user);
	
	}
  
	@Override
	public House getHouseById(Serializable id) {
		// TODO Auto-generated method stub
		return houseDao.getById(id);
	}



	@Override
	public List<House> getList() {
		// TODO Auto-generated method stub
		return houseDao.getList();
	}

	@Override
	public List<House> getList(String querycondition, int pageIndex, int pageSize) {
		
		return houseDao.getList(querycondition, pageIndex, pageSize);
	}

	@Override
	public int getCount(String querycondition) {
		// TODO Auto-generated method stub
		return houseDao.getCount(querycondition);
	}

	@Override
	public PageBean<House> findByPage(String querycondition, int pageIndex, int pageSize) {
		PageBean<House> pageBean=new PageBean<House>();
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		pageBean.setTotalCount(houseDao.getCount(querycondition));
		pageBean.setList(houseDao.getList(querycondition, (pageIndex-1)*pageSize, pageSize));
		return pageBean;
	}

	@Override
	public List<HouseType> findHouseType() {
		// TODO Auto-generated method stub
		return houseDao.findHouseType();
	}

	@Override
	public List<District> findDistrict() {
		// TODO Auto-generated method stub
		return houseDao.findDistrict();
	}

	@Override
	public List<Street> findStreetListByDisId(int disId) {
		// TODO Auto-generated method stub
		return houseDao.findStreetListByDisId(disId);
	}

 
  
}
